package controllers;

import com.google.gson.JsonObject;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

   public static void index() {
      render();
   }

   public static void price(final Price amount) {
      renderText(amount.toString());
   }

   public static void save(final JsonObject amount) {
      renderText(amount.toString());
   }
}