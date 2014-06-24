#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.validation;

import com.google.gwt.validation.client.AbstractValidationMessageResolver;
import com.google.gwt.validation.client.UserValidationMessagesResolver;

public class ValidationMessagesResolver extends
        AbstractValidationMessageResolver implements
        UserValidationMessagesResolver {

    protected ValidationMessagesResolver() {
        super(ValidationMessages.INSTANCE);
    }
}
