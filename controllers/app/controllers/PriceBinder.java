package controllers;

import models.Price;
import play.data.binding.Global;
import play.data.binding.TypeBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/**
 * Custom binder for price values, e.g. EUR5.14
 */
@Global
public class PriceBinder implements TypeBinder<Price> {

   @Override
   public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType) throws Exception {
      final String currencyCode = value.substring(0, 3);
      final String amountString = value.substring(3);
      final Number amount = new DecimalFormat("#.00").parse(amountString);
      final Double amountCents = Double.valueOf(amount.doubleValue() * 100);
      return new Price(currencyCode, amountCents.longValue());
   }
}
