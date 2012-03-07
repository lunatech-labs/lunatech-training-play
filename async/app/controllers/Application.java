package controllers;

import models.PrimeNumbers;
import play.cache.Cache;
import play.jobs.Job;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index() {
      render();
   }

   /**
    * Output the prime number with the given index, calculated synchronously.
    */
   public static void prime(final int index) {
      final long prime = PrimeNumbers.prime(index);
      renderText(String.valueOf(prime));
   }

   /**
    * Output the prime number with the given index, if cached.
    * If not cached, start a job to cache that result.
    */
   public static void cached(final int index) {
      Long prime = (Long) Cache.get(String.valueOf(index));

      if (prime == null) {
         new PrimeJob(index).now();
      }

      renderText(prime == null ? "unknown" : String.valueOf(prime));
   }

   private static class PrimeJob extends Job {
      private final int index;

      public PrimeJob(final int index) {
         this.index = index;
      }

      public void doJob() {
         final long prime = PrimeNumbers.prime(index);
         Cache.set(String.valueOf(index),  prime);
      }
   }
}