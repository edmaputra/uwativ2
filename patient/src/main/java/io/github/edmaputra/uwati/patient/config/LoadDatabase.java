package io.github.edmaputra.uwati.patient.config;

import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import io.github.edmaputra.uwati.patient.domain.mongo.Patient;
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
    CommandLineRunner init(PatientRepository repository) {
        return args -> {
            Flux.just(
                    new Patient(
                            "Bangun",
                            "Edma",
                            "Saputra",
                            Gender.MALE,
                            MaritalStatus.MARRIED,
                            "Kota Bangun",
                            LocalDate.of(1990, Month.JULY, 8),
                            "085348481919"
                    ),

                    new Patient(
                            "Andri",
                            "",
                            "Gunardi",
                            Gender.MALE,
                            MaritalStatus.MARRIED,
                            "Cicaheum",
                            LocalDate.of(1990, Month.JULY, 8),
                            "085348481919"
                    ))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }

}
