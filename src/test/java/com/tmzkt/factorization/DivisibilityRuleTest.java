package com.tmzkt.factorization;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class DivisibilityRuleTest {
    private DivisibilityRule divisibilityRule = new DivisibilityRule();

    @Test
    public void ZeroDivisibleBy2() {
        assertTrue(divisibilityRule.divisibleBy2(BigInteger.ZERO));
    }

    @Test
    public void OneNotDivisibleBy2() {
        assertFalse(divisibilityRule.divisibleBy2(BigInteger.ONE));
    }

    @Test
    public void TwoDivisibleBy2() {
        assertTrue(divisibilityRule.divisibleBy2(BigInteger.valueOf(2)));
    }

    @Test
    public void NegativeOddNumberNotDivisibleBy2() {
        assertFalse(divisibilityRule.divisibleBy2(BigInteger.valueOf(-7385)));
    }

    @Test
    public void NegativeEvenNumberDivisibleBy2() {
        assertTrue(divisibilityRule.divisibleBy2(BigInteger.valueOf(-9166)));
    }

    @Test
    public void LargeOddNumberNotDivisibleBy2() {
        assertFalse(divisibilityRule.divisibleBy2(BigInteger.valueOf(923759284721L)));
    }

    @Test
    public void LargeEvenNumberDivisibleBy2() {
        assertTrue(divisibilityRule.divisibleBy2(BigInteger.valueOf(35487946948L)));
    }

    @Test
    public void ZeroDivisibleBy3() {
        assertTrue(divisibilityRule.divisibleBy3(BigInteger.ZERO));
    }

    @Test
    public void OneNotDivisibleBy3() {
        assertFalse(divisibilityRule.divisibleBy3(BigInteger.ONE));
    }

    @Test
    public void NineDivisibleBy3() {
        assertTrue(divisibilityRule.divisibleBy3(BigInteger.valueOf(9)));
    }

    @Test
    public void NegativeNumberNotDivisibleBy3() {
        assertFalse(divisibilityRule.divisibleBy3(BigInteger.valueOf(-99811)));
    }

    @Test
    public void NegativeNumberDivisibleBy3() {
        assertTrue(divisibilityRule.divisibleBy3(BigInteger.valueOf(-37422)));
    }

    @Test
    public void LargeNumberNotDivisibleBy3() {
        assertFalse(divisibilityRule.divisibleBy3(BigInteger.valueOf(923759284721L)));
    }

    @Test
    public void LargeNumberDivisibleBy3() {
        assertTrue(divisibilityRule.divisibleBy3(BigInteger.valueOf(354879469482L)));
    }
}