package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

/**
 * An integer, with additional information about its prime factorisation.
 * 
 * @see http://en.wikipedia.org/wiki/Integer_factorization
 */
//@Entity
public class CompositeNumber extends Model {

   public int value;
   public boolean prime;
   public String primeFactorisation;
}
