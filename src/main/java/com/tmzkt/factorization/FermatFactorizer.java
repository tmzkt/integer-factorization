package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FermatFactorizer implements Factorizer {
    @Override
    public List<BigInteger> factor(BigInteger n) {
        List<BigInteger> factors = new ArrayList<BigInteger>();
        BigInteger a = sqrt(n); // TODO take ceiling
        BigInteger b2 = a.multiply(a).subtract(n);
        while (!isSquare(b2)) {
            a = a.add(BigInteger.ONE);
            b2 = a.multiply(a).subtract(n);
        }
        BigInteger r1 = a.subtract(sqrt(b2));
        BigInteger r2 = n.divide(r1);
        factors.add(r1);
        factors.add(r2);
        return factors;
    }

    // TODO move some of these methods into a more appropriate class
    private static BigInteger sqrt(BigInteger n) {
        if (n.signum() >= 0) {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root)) {
                root = root.add(n.divide(root)).divide(BigInteger.valueOf(2));
            }
            return root;
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
