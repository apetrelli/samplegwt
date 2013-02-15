#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.service;

import java.util.List;

import ${package}.model.domain.Person;
import com.github.utilgwt.model.service.CrudService;

public interface PersonService extends CrudService<Person, Long> {

	long countAllPersons();
	
	List<Person> findAllPersons();
}
