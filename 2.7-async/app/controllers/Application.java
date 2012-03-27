package controllers;

import models.PrimeNumbers;
import play.Logger;
import play.cache.Cache;
import play.data.binding.As;
import play.jobs.Job;
import play.libs.F;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Router;

import java.util.List;

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

   /**
    * Asynchronous job to calculate a prime, for a given index, and cache the result.
    */
   private static class PrimeJob extends Job {
      private final int index;

      public PrimeJob(final int index) {
         this.index = index;
      }

      public void doJob() {
         final long prime = PrimeNumbers.prime(index);
         Cache.set(String.valueOf(index), prime);
      }
   }

   /**
    * Output the prime number with the given index, suspending the request until the result is available.
    */
   public static void suspended(final int index) {
      final F.Promise<Long> result = new PrimeResultJob(index).now();
      final Long prime = await(result);
      renderText(prime);
   }

   /**
    * Asynchronous job to calculate a prime, for a given index, and return the result.
    */
   private static class PrimeResultJob extends Job<Long> {
      private final int index;

      public PrimeResultJob(final int index) {
         this.index = index;
      }

      public Long doJobWithResult() {
         return PrimeNumbers.prime(index);
      }
   }

   /**
    * Output the prime numbers with the given indices, by asynchronously executing WS requests.
    */
   public static void parallel(@As(",") final String[] indices) {

      if (indices.length != 3) {
         badRequest();
      }

      // Execute three asynchronous HTTP requests in parallel
      F.Promise<WS.HttpResponse> r1 = WS.url("http://localhost:9000/prime/" + indices[0]).getAsync();
      F.Promise<WS.HttpResponse> r2 = WS.url("http://localhost:9000/prime/" + indices[1]).getAsync();
      F.Promise<WS.HttpResponse> r3 = WS.url("http://localhost:9000/prime/" + indices[2]).getAsync();

      // Wait for all three responses
      F.Promise<List<WS.HttpResponse>> promises = F.Promise.waitAll(r1, r2, r3);
      await(promises, new F.Action<List<WS.HttpResponse>>() {

         // Process the three completed responses
         public void invoke(List<WS.HttpResponse> responses) {
            final StringBuilder result = new StringBuilder();
            for (WS.HttpResponse response : responses) {
               result.append(response.getString());
               result.append("\n");
            }
            renderText(result.toString());
         }
      });

   }

}