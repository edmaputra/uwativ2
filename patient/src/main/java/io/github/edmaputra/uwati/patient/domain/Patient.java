package io.github.edmaputra.uwati.patient.domain;

import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import io.github.edmaputra.edtmplte.domain.Person;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient extends Person {

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "patient_address",
            joinColumns = {@JoinColumn(name = "patient_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "address_id", nullable = false)}
    )
    protected Set<Address> addresses = new HashSet<>();

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<MedicalRecord> medicalRecords = new HashSet<>();

    public Patient() {
    }

    public Patient(
            @NotBlank(message = "First Name Cannot Null or Empty") String firstName,
            @NotNull(message = "Middle Name Cannot Null, Empty is acceptable") String middleName,
            @NotNull(message = "Last Name Cannot Null, Empty is acceptable") String lastName,
            @NotNull(message = "Gender Cannot Null") Gender gender,
            @NotNull(message = "Marital Status Cannot Null") MaritalStatus maritalStatus,
            @NotNull(message = "Birth Place Cannot Null") String birthPlace,
            @NotNull(message = "Birth Date Cannot Null") LocalDate birthDate,
            @NotNull(message = "Phone Number Cannot Null") String phoneNumber
            ) {
        super(firstName, middleName, lastName, gender, maritalStatus, birthPlace, birthDate, phoneNumber);
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecords.add(medicalRecord);
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }
}
