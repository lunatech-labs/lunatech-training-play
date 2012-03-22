package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate lists of prime numbers.
 */
public class PrimeNumbers {

   /**
    * Returns the list of prime numbers, in order, up to the given length.
    */
   public static List<Long> primes(final int length) {

      if (length < 1) {
         throw new IllegalArgumentException("length must be positive");
      }

      // Seed the list.
      final List<Long> primes = new ArrayList<Long>(length);
      primes.add(2L);

      // Loop over candidate prime numbers until the list of primes is full.
      long primeIndex = 1;
      for (long candidatePrime = 3; primeIndex < length; candidatePrime += 2) {
         boolean prime = true;

         // Optimisation: only check whether prime numbers divide the candidate.
         for (long factor: primes) {

            // Optimisation: don't check factors bigger than the square root.
            if (factor * factor > candidatePrime) {
               break;
            }

            // If the factor divides the candidate, then it's not prime.
            if (candidatePrime % factor == 0) {
               prime = false;
               break;
            }
         }

         // If the candidate is prime, then add it to the list.
         if (prime) {
            primes.add(candidatePrime);
            primeIndex++;
         }
      }

      return primes;
   }

}