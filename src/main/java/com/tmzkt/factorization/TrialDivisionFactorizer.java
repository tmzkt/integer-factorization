package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TrialDivisionFactorizer implements Factorizer {
    @Override
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (n.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }
        for (BigInteger p = BigInteger.valueOf(2); p.multiply(p).compareTo(n) <= 0; p = p.add(BigInteger.ONE)) {
            if (p.isProbablePrime(5)) { // TODO experiment with other certainty values
                while (n.mod(p).compareTo(BigInteger.ZERO) == 0) {
                    primeFactors.add(p);
                    n = n.divide(p);
                }
            }
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
