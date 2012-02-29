package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

   private final static int PAGE_SIZE = 100;

   public static void index() {
      render();
   }

   public static void inline() {
      final List<Long> primes = PrimeNumbers.primes(PAGE_SIZE);
      render(primes);
   }

}