package it.pkg.module.client.validation;

import javax.validation.Validator;

import it.pkg.module.client.requestfactory.proxy.PersonProxy;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

public class ValidatorFactory extends AbstractGwtValidatorFactory {

	@GwtValidation({PersonProxy.class})
	public interface GwtValidator extends Validator {
		
	}
	
	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}

}
