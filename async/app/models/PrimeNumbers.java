package models;

/**
 * Calculate prime numbers.
 */
public class PrimeNumbers {

   /**
    * Returns the prime number with the given index.
    */
   public static long prime(final int index) {

      if (index < 1) {
         throw new IllegalArgumentException("index must be positive");
      }

      // Seed the search.
      long primeNumber = 2L;
      long primeIndex = 1;

      // Loop over candidate prime numbers the index reaches the target index
      for (long candidatePrime = 2; primeIndex <= index; candidatePrime++) {
         boolean prime = true;

         // Loop over possible factors.
         // Optimisation: don't check factors bigger than the square root.
         for (long factor = 2; factor * factor <= candidatePrime; factor++) {

            // If the factor divides the candidate, then it's not prime.
            if (candidatePrime % factor == 0) {
               prime = false;
               break;
            }
         }

         // If the candidate is prime, then move on to the next candidate.
         if (prime) {
            primeNumber = candidatePrime;
            primeIndex++;
         }
      }

      return primeNumber;
   }

}
