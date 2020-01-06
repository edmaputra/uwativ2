package io.github.edmaputra.uwati.patient.controller;

import io.github.edmaputra.uwati.patient.domain.Patient;
import io.github.edmaputra.uwati.patient.repository.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Patient> findAll() {
        return repository.findAll();
    }
}
