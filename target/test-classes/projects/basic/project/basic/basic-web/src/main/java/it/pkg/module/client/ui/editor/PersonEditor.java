package it.pkg.module.client.ui.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.pkg.module.client.requestfactory.proxy.PersonProxy;
import it.pkg.shared.shared.enums.PersonalTitle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;

public class PersonEditor extends Composite implements Editor<PersonProxy>{
	
	@UiField(provided=true) ValueListBox<PersonalTitle> personalTitle;
	
	@UiField ValueBoxEditorDecorator<String> firstName;
	
	@UiField ValueBoxEditorDecorator<String> lastName;
	
	private static PersonEditorUiBinder uiBinder = GWT
			.create(PersonEditorUiBinder.class);

	interface PersonEditorUiBinder extends UiBinder<Widget, PersonEditor> {
	}

	public PersonEditor() {
		initPersonalTitle();
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void initPersonalTitle() {
		personalTitle = new ValueListBox<PersonalTitle>(new Renderer<PersonalTitle>() {

			@Override
			public String render(PersonalTitle object) {
				return object != null ? object.toString() : "";
			}

			@Override
			public void render(PersonalTitle object, Appendable appendable)
					throws IOException {
				appendable.append(render(object));
			}
		});
		List<PersonalTitle> titles = new ArrayList<PersonalTitle>();
		titles.add(null);
		titles.addAll(Arrays.asList(PersonalTitle.values()));
		personalTitle.setAcceptableValues(titles);
	}

}
