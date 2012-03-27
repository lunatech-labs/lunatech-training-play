package controllers;

import java.util.List;

import models.CompositeNumber;

import org.apache.commons.lang.StringUtils;

import play.data.validation.Valid;
import play.mvc.Controller;

public class Application extends Controller {

   public static void index() {
      final List<CompositeNumber> numbers = CompositeNumber.find(
            "order by value").fetch();
      render(numbers);
   }

   public static void hello(final String person) {
      renderText(String.format("Hello %s!", person));
   }

   public static void save(final CompositeNumber number) {
      number.save();
      index();
   }

//   public static void validate(final CompositeNumber number) {
//      
//      validation.required(number.value);
//      validation.min(number.value, 2);
//      
//      if (validation.hasErrors()) {
//         error(400, "Validation failed");
//      }
//      
//      number.save();
//      index();
//   }
//   
   public static void validate(@Valid(message = "That’s not a valid composite") final CompositeNumber number) {
   
      if (validation.hasErrors()) {
         error(400, StringUtils.join(validation.errors(), ", "));
      }
   
      number.save();
      index();
   }

}