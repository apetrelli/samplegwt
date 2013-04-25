package it.pkg.model.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import it.pkg.shared.shared.enums.PersonalTitle;
import com.github.apetrelli.gwtintegration.jpa.AbstractDeletable;
import com.github.apetrelli.gwtintegration.jpa.DeleteEntityListener;

@Entity
@EntityListeners({ DeleteEntityListener.class })
public class Person extends AbstractDeletable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Integer version;
	
	private PersonalTitle personalTitle;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	public Long getId() {
		return id;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public PersonalTitle getPersonalTitle() {
		return personalTitle;
	}

	public void setPersonalTitle(PersonalTitle personalTitle) {
		this.personalTitle = personalTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}