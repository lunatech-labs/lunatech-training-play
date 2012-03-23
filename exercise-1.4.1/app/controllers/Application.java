package controllers;

import java.util.List;

import models.PrimeNumbers;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index(final String person) {
      final List<Long> primes = PrimeNumbers.primes(20);
      render(person, primes);
   }
   
   public static void form() {
      render();
   }

}