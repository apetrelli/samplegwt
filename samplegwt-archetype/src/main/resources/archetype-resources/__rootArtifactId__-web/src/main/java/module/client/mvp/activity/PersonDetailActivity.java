#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.mvp.activity;

import ${package}.module.client.ClientFactory;
import ${package}.module.client.mvp.place.ListPersonsPlace;
import ${package}.module.client.mvp.place.PersonDetailPlace;
import ${package}.module.client.requestfactory.ApplicationRequestFactory;
import ${package}.module.client.requestfactory.proxy.PersonProxy;
import ${package}.module.client.requestfactory.request.PersonRequest;
import ${package}.module.client.ui.PersonDetailView;
import ${package}.module.client.ui.editor.PersonEditor;
import com.github.apetrelli.gwtintegration.web.client.editor.EditorWorkflow;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

public class PersonDetailActivity extends BaseActivity implements PersonDetailView.Presenter {
	
	private Long id;
	
	interface Driver extends RequestFactoryEditorDriver<PersonProxy, PersonEditor> {};
	
	private Driver driver;
	
	private EditorWorkflow<PersonProxy, PersonRequest, PersonEditor, Long> workflow;

	public PersonDetailActivity(PersonDetailPlace place, ApplicationRequestFactory requestFactory, ClientFactory clientFactory) {
		super(requestFactory, clientFactory);
		id = place.getId();
		driver = GWT.create(Driver.class);
		workflow = new EditorWorkflow<PersonProxy, PersonRequest, PersonEditor, Long>(requestFactory, driver, clientFactory.getPersonDetailView().getEditor()) {

			@Override
			protected PersonRequest getNewRequestContext() {
				return PersonDetailActivity.this.requestFactory.personRequest();
			}

			@Override
			protected Class<PersonProxy> getEntityProxyClass() {
				return PersonProxy.class;
			}
			
			@Override
			protected Long getEntityId(PersonProxy entityProxy) {
				return entityProxy.getId();
			}

			@Override
			protected void afterSave(PersonProxy response) {
				Window.alert("Save successful!");
				goTo(new PersonDetailPlace(response.getId()));
			}
			
			@Override
			protected void afterDelete() {
				Window.alert("Delete successful!");
				goTo(new ListPersonsPlace());
			}
		};
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		PersonDetailView view = clientFactory.getPersonDetailView();
		view.setPresenter(this);
		view.canDelete(id != null);
		panel.setWidget(view);
		workflow.start(id);
	}
	
	@Override
	public void save() {
		workflow.save();
	}
	
	@Override
	public void delete() {
		workflow.delete();
	}
}
