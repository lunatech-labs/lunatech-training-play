package models;

import play.db.jpa.Model;

public class User extends Model {

   public String name;
   public String email;
   public String password;
   
   public String newPassword() {
      this.password = "";
      return this.password;
   }
}
