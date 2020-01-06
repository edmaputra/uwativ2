package io.github.edmaputra.uwati.patient.domain;

import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class PatientAddressTest {

    Patient p1;
    Patient p2;
    Address address1;
    Address address2;

    @BeforeEach
    public void init() {
        p1 = new Patient(
                "Bangun",
                "Edma",
                "Saputra",
                Gender.MALE,
                MaritalStatus.MARRIED,
                "Kota Bangun",
                LocalDate.of(1990, Month.JULY, 8),
                "085348481919",
                "abc@test.com"
        );

        p2 = new Patient(
                "Andri",
                "",
                "Gunardi",
                Gender.MALE,
                MaritalStatus.MARRIED,
                "Cicaheum",
                LocalDate.of(1990, Month.JULY, 8),
                "085348481919",
                "abc@test.com"
        );

        address1 = new Address(
                "Jl. Pasir Kaliki",
                "Bandung",
                "Jawa Barat",
                "40162",
                "Indonesia"
        );

        address2 = new Address(
                "Jl. Cigending",
                "Ujung Berung",
                "Jawa Barat",
                "40165",
                "Indonesia"
        );
    }

    @Test
    public void whenAddressIsAddedToPatient_shouldReturnCorrectAddressAmount() {
        assertThat(p1.getAddresses().size()).isEqualTo(0);

        p1.addAddress(address1);
        p1.addAddress(address2);

        assertThat(p1.getAddresses().size()).isEqualTo(2);
        assertThat(p1.getAddresses()).contains(address1, address2);

        // when try to add with same object, should have replace the old one.
        p1.addAddress(address2);

        assertThat(p1.getAddresses().size()).isEqualTo(2);
        assertThat(p1.getAddresses()).contains(address1, address2);
    }

}