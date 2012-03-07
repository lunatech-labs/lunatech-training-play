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
      checkingCandidatePrimes:
      for (long candidatePrime = 2; primeIndex <= index; candidatePrime++) {
         boolean prime = true;

         // Loop over possible factors.
         // Optimisation: don't check factors bigger than the square root.
         for (long factor = 2; factor * factor <= candidatePrime; factor++) {

            // If the factor divides the candidate, then it's not prime.
            if (candidatePrime % factor == 0) {
               continue checkingCandidatePrimes;
            }
         }

         // We didn't find a factor, so the candidate is prime; move on to the next.
         primeNumber = candidatePrime;
         primeIndex++;
      }

      return primeNumber;
   }

}
