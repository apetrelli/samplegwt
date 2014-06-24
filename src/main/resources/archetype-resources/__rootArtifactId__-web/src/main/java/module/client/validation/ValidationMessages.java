#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.validation;

import com.google.gwt.core.shared.GWT;

public interface ValidationMessages extends org.hibernate.validator.ValidationMessages {

    public ValidationMessages INSTANCE = GWT.create(ValidationMessages.class);

    String personalTitleNotNull();

    String nameSurnameNotSame();
}
