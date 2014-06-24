#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui.impl;

import ${package}.module.client.ui.PersonDetailView;
import ${package}.module.client.ui.editor.PersonEditor;

import com.github.apetrelli.gwtintegration.editor.client.editor.ConstraintViolationDisplayer;
import com.github.apetrelli.gwtintegration.mvp.client.ui.impl.AbstractMvpView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class PersonDetailViewImpl extends AbstractMvpView<PersonDetailView.Presenter> implements PersonDetailView {

	@UiField PersonEditor editor;
	
	@UiField ConstraintViolationDisplayer genericDisplayer;

	@UiField Button save;
	
	@UiField Button delete;
	
	private static PersonDetailViewImplUiBinder uiBinder = GWT
			.create(PersonDetailViewImplUiBinder.class);

	interface PersonDetailViewImplUiBinder extends
			UiBinder<Widget, PersonDetailViewImpl> {
	}

	public PersonDetailViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public PersonEditor getEditor() {
		return editor;
	}
	
	@Override
	public ConstraintViolationDisplayer getGenericDisplayer() {
		return genericDisplayer;
	}

	@Override
	public void canDelete(boolean canDelete) {
		delete.setVisible(canDelete);
	}

	@UiHandler("save")
	void onSaveClick(ClickEvent event) {
		presenter.save();
	}

	@UiHandler("delete")
	void onDeleteClick(ClickEvent event) {
		presenter.delete();
	}
}
