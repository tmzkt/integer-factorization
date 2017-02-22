package com.tmzkt.factorization;

import java.math.BigInteger;

public class DivisibilityRule {
    public boolean divisibleBy2(BigInteger n) {
        String stringRepresentation = n.toString();
        int lastDigit = Character.getNumericValue(stringRepresentation.charAt(stringRepresentation.length() - 1));
        return lastDigit % 2 == 0;
    }
}
