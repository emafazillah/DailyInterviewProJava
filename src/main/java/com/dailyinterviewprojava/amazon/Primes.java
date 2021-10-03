package com.dailyinterviewprojava.amazon;

import java.util.Scanner;

/**
 * 
 * @author Fernando Boaglio
 * 
 *         Given a positive integer n, find all primes less than n.
 *
 */
public class Primes {

    public static void main(String... strings) {
        // Input n
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive integer number: ");

        String inputN = scanner.nextLine(); // Read user input

        long n = 0;
        try {
            n = Long.parseLong(inputN);
        } catch (NumberFormatException nfe) {
            System.out.println("invalid number: " + inputN);
            System.exit(0);
        }

        if (n < 0) {
            System.out.println("invalid negative number: " + inputN);
            System.exit(0);
        }

        System.out.println("Prime numbers less than " + n + " : ");

        // Print primes
        for (long a = 1; a <= n; a++) {
            if (isPrime(a)) {
                System.out.println("PRIME > " + a);
            }
        }

        scanner.close();
    }

    private static boolean isPrime(long a) {
        boolean isPrime = true;

        for (long b = 2; b < a; b++) {
            if (a % b == 0) {
                // Print no prime numbers
                System.out.println(" " + a + " is divided by " + b + " (not prime)");
                return false;
            }
        }
        return isPrime;
    }

}
