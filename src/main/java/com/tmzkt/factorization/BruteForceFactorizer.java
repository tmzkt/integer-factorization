package com.tmzkt.factorization;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class BruteForceFactorizer implements Factorizer {
    public BigInteger[] factor(BigInteger integer) {
        Queue<BigInteger> factors = new LinkedList<BigInteger>();
        factors.add(integer);



        return factors.toArray(new BigInteger[factors.size()]);
    }
}
