#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.requestfactory.proxy;

import org.hibernate.validator.constraints.NotEmpty;

import ${package}.model.domain.Person;
import ${package}.module.server.locator.PersonLocator;
import ${package}.shared.shared.enums.PersonalTitle;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Person.class, locator = PersonLocator.class)
public interface PersonProxy extends EntityProxy {
	
	Long getId();
	
	Integer getVersion();
	
	PersonalTitle getPersonalTitle();
	
	void setPersonalTitle(PersonalTitle personalTitle);
	
	@NotEmpty
	String getFirstName();
	
	void setFirstName(String firstName);
	
	@NotEmpty
	String getLastName();
	
	void setLastName(String lastName);
}
