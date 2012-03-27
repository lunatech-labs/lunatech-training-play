package models;

import javax.persistence.Entity;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * An integer, with additional information about its prime factorisation.
 * 
 * @see http://en.wikipedia.org/wiki/Integer_factorization
 */
@Entity
public class CompositeNumber extends Model {

   @Min(value = 2, message = "must be greater than 1")
   @Required(message = "validation.value")
   public Integer value;
   
   public boolean prime;
   public String primeFactorisation;
   
   @Override
   public String toString() {
      final StringBuilder result = new StringBuilder();
      result.append(value);
      if (prime) {
         result.append(" (prime)");
      }
      else {
         result.append(" = ");         
         result.append(primeFactorisation);
      }
      return result.toString();
   }
}
