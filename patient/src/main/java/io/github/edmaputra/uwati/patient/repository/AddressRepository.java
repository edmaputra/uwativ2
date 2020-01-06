package io.github.edmaputra.uwati.patient.repository;

import io.github.edmaputra.uwati.patient.domain.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AddressRepository extends ReactiveCrudRepository<Address, String> {
}
