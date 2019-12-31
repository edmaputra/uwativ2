package io.github.edmaputra.uwati.patient.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address extends io.github.edmaputra.edtmplte.domain.Address {

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "addresses")
    protected Set<Patient> patients = new HashSet<>();

    public Address() {
    }

    public Address(
            @NotBlank(message = "Street Name Cannot Null or Empty") String street,
            @NotBlank(message = "City Name Cannot Null or Empty") String city,
            @NotBlank(message = "Province Name Cannot Null or Empty") String province,
            @NotBlank(message = "Zip Code Name Cannot Null or Empty") String zipCode,
            @NotBlank(message = "Country Name Cannot Null or Empty") String country) {
        super(street, city, province, zipCode, country);
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void addPerson(Patient patient) {
        this.patients.add(patient);
    }

}
