#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.github.apetrelli.gwtintegration.jpa.AbstractDeletable;
import com.github.apetrelli.gwtintegration.jpa.DeleteEntityListener;
import ${package}.shared.shared.enums.PersonalTitle;

@Entity
@EntityListeners({ DeleteEntityListener.class })
public class Person extends AbstractDeletable {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @NotNull
    private PersonalTitle personalTitle;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Date birthDate;

    private BigDecimal annualIncome;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }
}
