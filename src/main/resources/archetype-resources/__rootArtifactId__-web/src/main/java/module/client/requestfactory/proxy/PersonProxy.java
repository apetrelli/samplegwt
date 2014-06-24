#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.requestfactory.proxy;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ${package}.model.domain.Person;
import ${package}.module.client.validation.constraint.NameSurnameNotSame;
import ${package}.module.server.locator.PersonLocator;
import ${package}.shared.shared.enums.PersonalTitle;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Person.class, locator = PersonLocator.class)
@NameSurnameNotSame
public interface PersonProxy extends EntityProxy {
	
	Long getId();
	
	Integer getVersion();
	
	@NotNull(message = "{personalTitleNotNull}")
	PersonalTitle getPersonalTitle();
	
	void setPersonalTitle(PersonalTitle personalTitle);
	
	@NotEmpty
	String getFirstName();
	
	void setFirstName(String firstName);
	
	@NotEmpty
	String getLastName();
	
	void setLastName(String lastName);
	
	Date getBirthDate();
	
	void setBirthDate(Date birthDate);
	
	BigDecimal getAnnualIncome();
	
	void setAnnualIncome(BigDecimal annualIncome);
}
