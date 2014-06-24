#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.ui;

import com.github.apetrelli.gwtintegration.mvp.client.ui.HasBody;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ${moduleName}Template extends Composite implements HasBody {

    private static ${moduleName}TemplateUiBinder uiBinder = GWT
            .create(${moduleName}TemplateUiBinder.class);
    @UiField SimplePanel body;

    interface ${moduleName}TemplateUiBinder extends
            UiBinder<Widget, ${moduleName}Template> {
    }

    public ${moduleName}Template() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public AcceptsOneWidget getBody() {
        return body;
    }
}
