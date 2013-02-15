#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.model.domain.Person;
import ${package}.model.repository.PersonRepository;
import ${package}.model.service.PersonService;

@Service
@Transactional(readOnly=true)
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repository;
	
	public long countAllPersons() {
		return repository.count();
	}

	public List<Person> findAllPersons() {
		return repository.findAll();
	}

	public Person findOne(Long id) {
		return repository.findOne(id);
	}

	@Transactional(readOnly=false)
	public Person save(Person person) {
		return repository.save(person);
	}

	@Transactional(readOnly=false)
	public void delete(Long id) {
		repository.delete(id);
	}
}
