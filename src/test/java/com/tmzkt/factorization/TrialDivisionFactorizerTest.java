package com.tmzkt.factorization;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

public class TrialDivisionFactorizerTest {

    @Test
    public void negativeNumberReturnsEmptyArray() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.valueOf(-5));
        assertTrue(primeFactos.isEmpty());
    }

    @Test
    public void zeroReturnsEmptyArray() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.ZERO);
        assertTrue(primeFactos.isEmpty());
    }

    @Test
    public void oneReturnsEmptyArray() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.ONE);
        assertTrue(primeFactos.isEmpty());
    }

    @Test
    public void twoReturnsTwo() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.ONE);
        assertEquals(1, primeFactos.size());
        assertEquals(2, primeFactos.get(0).intValue());
    }

}