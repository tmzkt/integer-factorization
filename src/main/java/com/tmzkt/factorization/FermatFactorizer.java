package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FermatFactorizer implements Factorizer {
    @Override
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> primeFactors = new ArrayList<>();
        if (n.compareTo(BigInteger.valueOf(2)) < 0) {
            return primeFactors;
        }

        // TODO maybe we could remove all factors of two here to guarantee the number is odd from now on
        BigInteger fermatFactor = fermat(n);
        while (n.compareTo(BigInteger.ONE) > 0) {
            primeFactors.add(fermatFactor);
            n = n.divide(fermatFactor);
            fermatFactor = fermat(n);
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            primeFactors.addAll(new TrialDivisionFactorizer().factor(n));
        }
        return primeFactors;
    }

    private static BigInteger fermat(BigInteger n) {
        if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
            throw new IllegalArgumentException("n must be odd to use fermat");
        }
        BigInteger a = sqrt(n);
        BigInteger b2 = a.multiply(a).subtract(n);
        while (!isSquare(b2)) {
            a = a.add(BigInteger.ONE);
            b2 = a.multiply(a).subtract(n);
        }
        BigInteger r1 = a.subtract(sqrt(b2));

        if (r1.compareTo(BigInteger.ONE) == 0) {
            return n; // n is prime
        }
        return r1;
    }

    // TODO move some of these methods into a more appropriate class
    private static BigInteger sqrt(BigInteger n) {
        if (n.signum() >= 0) {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root)) {
                root = root.add(n.divide(root)).divide(BigInteger.valueOf(2));
            }
            if (root.pow(2).compareTo(n) == 0) {
                return root;
            }
            return root.add(BigInteger.ONE);
        } else {
            throw new ArithmeticException("square root of negative number");
        }
    }

    private static boolean isSqrt(BigInteger n, BigInteger root) {
        final BigInteger lowerBound = root.pow(2);
        final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
        return lowerBound.compareTo(n) <= 0
                && n.compareTo(upperBound) < 0;
    }

    private static boolean isSquare(BigInteger n) {
        BigInteger sqr = sqrt(n);
        BigInteger sqrPlus1 = sqr.add(BigInteger.ONE);
        return sqr.multiply(sqr).compareTo(n) == 0
                || sqrPlus1.multiply(sqrPlus1).compareTo(n) == 0;
    }
}
