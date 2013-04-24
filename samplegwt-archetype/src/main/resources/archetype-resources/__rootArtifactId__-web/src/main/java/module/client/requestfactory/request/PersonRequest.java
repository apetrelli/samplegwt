#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.client.requestfactory.request;

import java.util.List;

import com.github.apetrelli.gwtintegration.spring.context.requestfactory.GwtServiceLocator;
import com.github.apetrelli.gwtintegration.web.client.requestfactory.CrudRequest;
import ${package}.model.service.PersonService;
import ${package}.module.client.requestfactory.proxy.PersonProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = PersonService.class, locator = GwtServiceLocator.class)
public interface PersonRequest extends CrudRequest<PersonProxy, Long> {
	
	Request<PersonProxy> findOne(Long id);
	
	Request<PersonProxy> save(PersonProxy entityProxy);
	
	Request<Void> delete(Long id);

	Request<Long> countAllPersons();
	
	Request<List<PersonProxy>> findAllPersons();
}
