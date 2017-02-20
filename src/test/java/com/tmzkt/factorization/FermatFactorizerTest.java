package com.tmzkt.factorization;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FermatFactorizerTest {

    @Test
    public void negativeNumberReturnsEmptyArray() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.valueOf(-5));
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void zeroReturnsEmptyArray() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.ZERO);
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void oneReturnsEmptyArray() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.ONE);
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void twoReturnsTwo() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.valueOf(2));
        assertEquals(1, primeFactos.size());
        assertEquals(2, primeFactos.get(0).intValue());
    }

    @Test
    public void nineReturnsThreeThree() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.valueOf(9));
        assertEquals(2, primeFactors.size());
        assertEquals(3, primeFactors.get(0).intValue());
        assertEquals(3, primeFactors.get(1).intValue());
    }

    @Test
    public void twelveReturnsTwoTwoThree() {
        List<BigInteger> primeFactos = new TrialDivisionFactorizer().factor(BigInteger.valueOf(12));
        assertEquals(3, primeFactos.size());
        assertEquals(2, primeFactos.get(0).intValue());
        assertEquals(2, primeFactos.get(1).intValue());
        assertEquals(3, primeFactos.get(2).intValue());
    }

    @Test
    public void seventeenIsPrime() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.valueOf(17));
        assertEquals(1, primeFactors.size());
        assertEquals(17, primeFactors.get(0).intValue());
    }

    @Test
    public void seventyFiveReturnsThreeFiveFive() {
        List<BigInteger> primeFactors = new FermatFactorizer().factor(BigInteger.valueOf(75));
        assertEquals(3, primeFactors.size());
        assertEquals(3, primeFactors.get(0).intValue());
        assertEquals(5, primeFactors.get(1).intValue());
        assertEquals(5, primeFactors.get(2).intValue());
    }
}