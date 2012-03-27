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

   public static void validate(@Valid final CompositeNumber number) {
   
      if (validation.hasErrors()) {
         error(400, StringUtils.join(validation.errors(), ", "));
      }
   
      number.save();
      index();
   }

}