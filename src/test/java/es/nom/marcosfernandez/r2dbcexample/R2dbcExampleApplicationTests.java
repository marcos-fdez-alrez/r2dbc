package es.nom.marcosfernandez.r2dbcexample;

import es.nom.marcosfernandez.r2dbcexample.repository.PolicyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import es.nom.marcosfernandez.r2dbcexample.model.Policy;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@SpringBootTest(classes = Configuration.class)
class R2dbcExampleApplicationTests {

	@Autowired
	PolicyRepository policyRepository;
	@Autowired
	DatabaseClient client;

	@BeforeEach
	void setUp() {
		Hooks.onOperatorDebug();

		List<Policy> policies = Arrays.asList(	new Policy(null, "PLC-012345", LocalDate.now(), BigDecimal.valueOf(1000)) ,
												new Policy(null, "PLC-212345", LocalDate.now(), BigDecimal.valueOf(1000)));

		policyRepository.saveAll(policies)
				.as(StepVerifier::create)
				.expectNextCount(2)
				.verifyComplete();
	}

	@Test
	void countBySimpleExample() {

		var example = Example.of(new Policy(null, null, null, BigDecimal.valueOf(1000)));

		policyRepository.count(example).as(StepVerifier::create) //
				.expectNext(2L) //
				.verifyComplete();
	}

}
