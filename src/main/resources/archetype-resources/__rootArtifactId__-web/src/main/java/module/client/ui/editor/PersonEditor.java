#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui.editor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.github.apetrelli.gwtintegration.editor.client.widget.LeafValueEditorDecorator;
import com.github.apetrelli.gwtintegration.editor.client.widget.ValueDateBox;
import ${package}.module.client.requestfactory.proxy.PersonProxy;
import ${package}.shared.shared.enums.PersonalTitle;
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

    @UiField LeafValueEditorDecorator<ValueListBox<PersonalTitle>, PersonalTitle> personalTitle;

    @Ignore
    @UiField(provided=true) ValueListBox<PersonalTitle> personalTitleListBox;

    @UiField ValueBoxEditorDecorator<String> firstName;

    @UiField ValueBoxEditorDecorator<String> lastName;

    @UiField LeafValueEditorDecorator<ValueDateBox, Date> birthDate;

    @UiField ValueBoxEditorDecorator<BigDecimal> annualIncome;

    private static PersonEditorUiBinder uiBinder = GWT
            .create(PersonEditorUiBinder.class);

    interface PersonEditorUiBinder extends UiBinder<Widget, PersonEditor> {
    }

    public PersonEditor() {
        initPersonalTitle();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initPersonalTitle() {
        personalTitleListBox = new ValueListBox<PersonalTitle>(new Renderer<PersonalTitle>() {

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
        personalTitleListBox.setAcceptableValues(titles);
    }

}
