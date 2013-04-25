package it.pkg.model.service;

import java.util.List;

import it.pkg.model.domain.Person;
import com.github.apetrelli.gwtintegration.service.CrudService;

public interface PersonService extends CrudService<Person, Long> {

	long countAllPersons();
	
	List<Person> findAllPersons();
}
