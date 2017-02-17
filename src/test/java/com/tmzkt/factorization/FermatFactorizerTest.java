package com.tmzkt.factorization;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FermatFactorizerTest {

    @Test
    public void negativeNumberReturnsEmptyArray() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.valueOf(-5));
        assertTrue(primeFactos.isEmpty());
    }

    @Test
    public void zeroReturnsEmptyArray() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.ZERO);
        assertTrue(primeFactos.isEmpty());
    }

    @Test
    public void oneReturnsEmptyArray() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.ONE);
        assertTrue(primeFactos.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void evenNumberUnsupported() {
        new FermatFactorizer().factor(BigInteger.valueOf(22));
    }

    @Test
    public void nineReturnsThreeThree() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.valueOf(9));
        assertEquals(2, primeFactos.size());
        assertEquals(3, primeFactos.get(0).intValue());
        assertEquals(3, primeFactos.get(1).intValue());
    }

    @Test
    public void seventyFiveReturnsThreeFiveFive() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.valueOf(75));
        assertEquals(3, primeFactos.size());
        assertEquals(3, primeFactos.get(0).intValue());
        assertEquals(5, primeFactos.get(1).intValue());
        assertEquals(5, primeFactos.get(2).intValue());
    }

    @Test
    public void seventeenIsPrime() {
        List<BigInteger> primeFactos = new FermatFactorizer().factor(BigInteger.valueOf(17));
        assertEquals(1, primeFactos.size());
        assertEquals(17, primeFactos.get(0).intValue());
    }
}