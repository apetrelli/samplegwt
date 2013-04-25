package it.pkg.module.client.ui;

import com.github.apetrelli.gwtintegration.mvp.client.ui.HasBody;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class basicmoduleTemplate extends Composite implements HasBody {

	private static basicmoduleTemplateUiBinder uiBinder = GWT
			.create(basicmoduleTemplateUiBinder.class);
	@UiField SimplePanel body;

	interface basicmoduleTemplateUiBinder extends
			UiBinder<Widget, basicmoduleTemplate> {
	}

	public basicmoduleTemplate() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public AcceptsOneWidget getBody() {
		return body;
	}
}
