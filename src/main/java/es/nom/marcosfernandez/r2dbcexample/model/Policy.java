package es.nom.marcosfernandez.r2dbcexample.model;


import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Objects;

public record Policy(@Id Integer id, String policyNumber, LocalDate year, BigDecimal assuredAmount) {

    boolean hasId() {
        return id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber) && Objects.equals(year, policy.year) && Objects.equals(assuredAmount, policy.assuredAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, year, assuredAmount);
    }
}
