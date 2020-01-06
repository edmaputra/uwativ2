package io.github.edmaputra.uwati.patient.domain;

import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import io.github.edmaputra.edtmplte.domain.Person;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Document
public class Patient extends Person<String> {

    protected Set<Address> addresses = new HashSet<>();

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
            @NotNull(message = "Phone Number Cannot Null") String phoneNumber,
            String email
    ) {
        super(firstName, middleName, lastName, gender, maritalStatus, birthPlace, birthDate, phoneNumber, email);
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addMedicalRecords(MedicalRecord medicalRecord) {
        this.medicalRecords.add(medicalRecord);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "addresses=" + addresses +
                ", medicalRecords=" + medicalRecords +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
