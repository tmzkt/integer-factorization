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
}