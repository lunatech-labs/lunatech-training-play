package controllers;

import java.util.List;

import models.CompositeNumber;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index() {
      final List<CompositeNumber> numbers = CompositeNumber.findAll();
//      final List<CompositeNumber> numbers = CompositeNumber.find("byPrime", false).fetch();
//      final List<CompositeNumber> numbers = CompositeNumber.all().from(10).fetch(5);
//      final List<CompositeNumber> numbers = CompositeNumber.find("order by prime desc").fetch();
//      final List<CompositeNumber> numbers = CompositeNumber.find("byPrimeFactorisationLike", "%²%").fetch();
//      final List<CompositeNumber> numbers = CompositeNumber.find("from CompositeNumber where value > ? and primeFactorisation like ?", 10, "%3%").fetch();
      render(numbers);
   }
}