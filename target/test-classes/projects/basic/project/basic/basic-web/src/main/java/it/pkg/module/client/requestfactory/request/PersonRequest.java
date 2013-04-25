package it.pkg.module.client.requestfactory.request;

import java.util.List;

import com.github.apetrelli.gwtintegration.editor.client.requestfactory.CrudRequest;
import com.github.apetrelli.gwtintegration.spring.context.requestfactory.GwtServiceLocator;
import it.pkg.model.service.PersonService;
import it.pkg.module.client.requestfactory.proxy.PersonProxy;
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
