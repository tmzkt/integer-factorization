package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PollardRhoFactorizer implements Factorizer {
    private final TrialDivisionFactorizer trialDivisionFactorizer = new TrialDivisionFactorizer();

    @Override
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (n.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }

        BigInteger x = BigInteger.valueOf(2), y = BigInteger.valueOf(2), d = BigInteger.ONE;
        while (d.compareTo(BigInteger.ONE) == 0) {
            x = g(x);
            y = g(g(y));
            d = n.gcd(x.subtract(y).abs());
        }
        if (d.compareTo(n) == 0) {
            primeFactors.addAll(trialDivisionFactorizer.factor(n)); // failed, so use trial division instead
            return primeFactors;
        }

        primeFactors.add(d);
        primeFactors.addAll(factor(n.divide(d)));
        Collections.sort(primeFactors);
        return primeFactors;
    }

    private static BigInteger g(BigInteger x) {
        return x.multiply(x).add(BigInteger.ONE);
    }
}
