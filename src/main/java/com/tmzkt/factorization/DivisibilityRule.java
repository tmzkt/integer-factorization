package com.tmzkt.factorization;

import java.math.BigInteger;

public class DivisibilityRule {
    public boolean divisibleBy2(BigInteger n) {
        String stringRepresentation = n.toString();
        int lastDigit = Character.getNumericValue(stringRepresentation.charAt(stringRepresentation.length() - 1));
        return lastDigit % 2 == 0;
    }

    public boolean divisibleBy3(BigInteger n) {
        String stringRepresentation = n.abs().toString();
        while (stringRepresentation.length() > 1) {
            long totalOfDigits = 0;
            for (char c : stringRepresentation.toCharArray()) {
                totalOfDigits += Character.getNumericValue(c);
            }
            stringRepresentation = String.valueOf(totalOfDigits);
        }
        return Integer.parseInt(stringRepresentation) % 3 == 0;
    }
}
