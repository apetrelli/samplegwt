#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.validation.validator;

import ${package}.module.client.requestfactory.proxy.PersonProxy;
import ${package}.module.client.validation.constraint.NameSurnameNotSame;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameSurnameNotSameValidator implements ConstraintValidator<NameSurnameNotSame, PersonProxy>  {

	@Override
	public void initialize(NameSurnameNotSame constraintAnnotation) {
	}

	@Override
	public boolean isValid(PersonProxy value, ConstraintValidatorContext context) {
		return value.getFirstName() == null || value.getLastName() == null
				|| !value.getLastName().equals(value.getFirstName());
	}

}
