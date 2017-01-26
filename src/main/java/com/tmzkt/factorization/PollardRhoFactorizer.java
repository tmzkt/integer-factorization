package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PollardRhoFactorizer implements Factorizer {
    @Override
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (n.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }

        return primeFactors;
    }
}
