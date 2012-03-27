package templates;

import play.templates.JavaExtensions;

import java.text.DecimalFormat;

/**
 * Java object type extensions for use in templates.
 */
public class PrimesJavaExtensions extends JavaExtensions {

   public static String index(final Integer index) {
      return new DecimalFormat("(0)").format(index);
   }
}
