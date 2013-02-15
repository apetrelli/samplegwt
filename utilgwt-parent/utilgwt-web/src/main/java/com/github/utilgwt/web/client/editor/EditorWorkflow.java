package com.github.utilgwt.web.client.editor;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.github.utilgwt.web.client.requestfactory.CrudRequest;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.Window;
import com.google.gwt.validation.client.impl.Validation;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public abstract class EditorWorkflow<T extends EntityProxy, R extends CrudRequest<T, I>, E extends Editor<T>, I> {
	
	private T currentEntity;
	
	private R currentRequestContext;
	
	private Request<T> currentSaveRequest;

	private RequestFactory requestFactory;
	
	private RequestFactoryEditorDriver<T, E> driver;
	
	private E editor;

	/**
	 * @param driver
	 */
	public EditorWorkflow(RequestFactory requestFactory,
			RequestFactoryEditorDriver<T, E> driver, E editor) {
		this.requestFactory = requestFactory;
		this.driver = driver;
		this.editor = editor;
	}
	
	public void start(I id) {
		currentRequestContext = getNewRequestContext();
		driver.initialize(requestFactory, editor);
		if (id != null) {
			getNewFindRequest(currentRequestContext, id).with(driver.getPaths()).fire(new Receiver<T>() {

				@Override
				public void onSuccess(T response) {
					currentRequestContext = getNewRequestContext();
					currentEntity = currentRequestContext.edit(response);
					driver.edit(currentEntity, currentRequestContext);
				}
			});
		} else {
			currentEntity = currentRequestContext.create(getEntityProxyClass());
			driver.edit(currentEntity, currentRequestContext);
		}
	}
	
	public void save() {
		@SuppressWarnings("unchecked")
		R request = (R) driver.flush();
		if (driver.hasErrors()) {
			Window.alert("Errors");
			return;
		}
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<ConstraintViolation<?>> violations = (Set) validator.validate(currentEntity);
		if (violations != null && !violations.isEmpty()) {
			driver.setConstraintViolations(violations);
			return;
		}
		if (currentSaveRequest == null) {
			currentSaveRequest = getNewSaveRequest(request, currentEntity);
		}
		currentSaveRequest.fire(new Receiver<T>() {

			@Override
			public void onConstraintViolation(
					Set<ConstraintViolation<?>> violations) {
				driver.setConstraintViolations(violations);
			}
			
			@Override
			public void onSuccess(T response) {
				afterSave(response);
			}
		});
	}
	
	public void delete() {
		getNewDeleteRequest(getNewRequestContext(), currentEntity).fire(new Receiver<Void>() {

			@Override
			public void onSuccess(Void response) {
				afterDelete();
			}
		});
	}

	protected Request<Void> getNewDeleteRequest(R r, T entityProxy) {
		return r.delete(getEntityId(entityProxy));
	}

	protected Request<T> getNewFindRequest(R requestContext, I id) {
		return requestContext.findOne(id);
	}
	
	protected Request<T> getNewSaveRequest(R requestContext, T entity) {
		return requestContext.save(entity);
	}

	protected abstract R getNewRequestContext();

	protected abstract Class<T> getEntityProxyClass();

	protected abstract I getEntityId(T entityProxy);
	
	protected abstract void afterSave(T response);
	
	protected abstract void afterDelete();
}
