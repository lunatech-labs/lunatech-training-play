package models;

/**
 * An exact product price in ‘cents’ or ‘pennies’.
 */
public class Price {

   /* ISO 4217 currency code */
   public String code;

   /* Exact currency amount in the minor unit, e.g. cents. */
   public Long amount;
   
   public Price(final String code, final long amount) {
      this.code = code;
      this.amount = amount;
   }
   
   @Override
   public String toString() {
      return String.format("code = %s, amount = %d", code, amount);
   }
}
