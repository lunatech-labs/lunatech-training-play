package controllers;

import java.util.List;

import models.CompositeNumber;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index() {
      final List<CompositeNumber> numbers = CompositeNumber.findAll();
      render(numbers);
   }
}