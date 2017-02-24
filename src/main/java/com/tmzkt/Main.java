package com.tmzkt;

import com.tmzkt.factorization.TrialDivisionFactorizer;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = null;
        while (number == null) {
            System.out.print("Enter number to be factored: ");
            String numberAsString = scanner.nextLine();
            try {
                number = new BigInteger(numberAsString);
            } catch(NumberFormatException ex) {
                // do nothing
            }
        }

        long timestamp = System.currentTimeMillis();
        System.out.println(new TrialDivisionFactorizer().factor(number));
        System.out.println((System.currentTimeMillis() - timestamp) + "ms elapsed");

        scanner.nextLine();
    }
}
