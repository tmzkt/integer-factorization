package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TrialDivisionFactorizer implements Factorizer {
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (n.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }
        // TODO make sure p is prime before checking against n
        for (BigInteger p = BigInteger.valueOf(2); p.multiply(p).compareTo(n) <= 0; p = p.add(BigInteger.ONE)) {
            while (n.mod(p).compareTo(BigInteger.ZERO) == 0) {
                primeFactors.add(p);
                n = n.divide(p);
            }
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
