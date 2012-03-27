package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

   private final static int PAGE_SIZE = 100;

   /**
    * Home page - list of examples.
    */
   public static void index() {
      render();
   }

   /**
    * Render the given example with the list of prime numbers.
    *
    * @param template Example template file base name
    */
   public static void example(final String template) {
      final List<Long> primes = PrimeNumbers.primes(PAGE_SIZE);
      render("Application/" + template + ".html", primes);
   }

}