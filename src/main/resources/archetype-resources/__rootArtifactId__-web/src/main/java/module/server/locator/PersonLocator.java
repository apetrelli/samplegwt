#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.module.server.locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ${package}.model.domain.Person;
import ${package}.model.service.PersonService;
import com.github.apetrelli.gwtintegration.hibernate.core.locator.DeproxierDeletableLocator;

@Component
public class PersonLocator extends DeproxierDeletableLocator<Person, Long> {

    @Autowired
    private PersonService service;

    @Override
    public Person create(Class<? extends Person> clazz) {
        return new Person();
    }

    @Override
    public Person find(Long id) {
        return service.findOne(id);
    }

    @Override
    public Class<Person> getDomainType() {
        return Person.class;
    }

    @Override
    public Long getId(Person domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Person domainObject) {
        return domainObject.getVersion();
    }
}
