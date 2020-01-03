package io.github.edmaputra.uwati.patient.repository;

import io.github.edmaputra.uwati.patient.domain.mongo.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
}
