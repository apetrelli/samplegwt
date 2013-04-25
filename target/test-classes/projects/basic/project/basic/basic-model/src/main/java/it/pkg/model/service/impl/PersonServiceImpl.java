package it.pkg.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.apetrelli.gwtintegration.datajpa.AbstractCrudService;
import it.pkg.model.domain.Person;
import it.pkg.model.repository.PersonRepository;
import it.pkg.model.service.PersonService;

@Service
@Transactional(readOnly=true)
public class PersonServiceImpl extends AbstractCrudService<Person, Long, PersonRepository> implements PersonService{
	
	@Autowired
	public PersonServiceImpl(PersonRepository repository) {
		super(repository);
	}
	
	public long countAllPersons() {
		return repository.count();
	}

	public List<Person> findAllPersons() {
		return repository.findAll();
	}
}
