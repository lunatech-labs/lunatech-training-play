package controllers;

import java.util.Collections;
import java.util.List;

import models.CompositeNumber;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index() {
      final List<CompositeNumber> numbers = Collections.emptyList();
      render(numbers);
   }
}