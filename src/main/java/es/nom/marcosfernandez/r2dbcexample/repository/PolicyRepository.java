package es.nom.marcosfernandez.r2dbcexample.repository;

import es.nom.marcosfernandez.r2dbcexample.model.Policy;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;



public interface PolicyRepository extends ReactiveCrudRepository<Policy, String>, ReactiveQueryByExampleExecutor<Policy> {}

