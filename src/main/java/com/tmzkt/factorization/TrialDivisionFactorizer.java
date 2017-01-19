package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TrialDivisionFactorizer implements Factorizer {
    public List<BigInteger> factor(BigInteger integer) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (integer.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }
        // TODO the algorithm
        if (integer.compareTo(BigInteger.ONE) > 0) {
            primeFactors.add(integer);
        }
        return primeFactors;
    }
}
