package notifiers;
 
import models.User;
import play.mvc.Mailer;
 
public class MailNotifier extends Mailer {
 
   public static void welcome(User user) {
      setSubject("Welcome %s", user.name);
      addRecipient(user.email);
      setFrom("Application Support <support@example.com>");
      send(user);
   }
}
