package io.github.edmaputra.uwati.patient.config;

import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import io.github.edmaputra.uwati.patient.domain.Address;
import io.github.edmaputra.uwati.patient.domain.Patient;
import io.github.edmaputra.uwati.patient.repository.AddressRepository;
import io.github.edmaputra.uwati.patient.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init(PatientRepository repository, AddressRepository addressRepository) {
        Patient p1 = new Patient("Bangun",
                "Edma",
                "Saputra",
                Gender.MALE,
                MaritalStatus.MARRIED,
                "Kota Bangun",
                LocalDate.of(1990, Month.JULY, 8),
                "085348481919",
                "abc@test.com");
        Patient p2 = new Patient(
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
        Address add1 = new Address(
                "Jl. Pasir Kaliki",
                "Bandung",
                "Jawa Barat",
                "40162",
                "Indonesia"
        );
        Address add2 = new Address(
                "Jl. Cigending",
                "Ujung Berung",
                "Jawa Barat",
                "40168",
                "Indonesia"
        );
        p1.addAddress(add2);
        p2.addAddress(add1);

        Flux.just(add1, add2).flatMap(addressRepository::save).subscribe();
        return args -> {
            Flux.just(p1, p2)
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }

}
