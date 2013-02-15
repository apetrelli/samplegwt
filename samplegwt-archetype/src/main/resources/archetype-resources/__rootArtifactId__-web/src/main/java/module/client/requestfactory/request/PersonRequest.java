#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.requestfactory.request;

import java.util.List;

import ${package}.module.client.requestfactory.proxy.PersonProxy;
import com.github.utilgwt.web.client.requestfactory.CrudRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value = "${package}.model.service.PersonService", locator="com.github.utilgwt.web.server.gwt.GwtServiceLocator")
public interface PersonRequest extends CrudRequest<PersonProxy, Long> {
	
	Request<PersonProxy> findOne(Long id);
	
	Request<PersonProxy> save(PersonProxy entityProxy);
	
	Request<Void> delete(Long id);

	Request<Long> countAllPersons();
	
	Request<List<PersonProxy>> findAllPersons();
}
