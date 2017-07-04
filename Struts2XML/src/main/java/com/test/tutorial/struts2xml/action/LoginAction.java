package com.test.tutorial.struts2xml.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
 
   private static final long serialVersionUID = 7299264265184515893L;
   private String username;
   private String password;
 
   @Override
   public String execute() {
       if (this.username != null && this.password != null
               && this.username.equals("admin")
               && this.password.equals("admin123")) {
           return "success";
       } else {
           addActionError(getText("error.login"));
           return "error";
       }
   }
 
   public String getUsername() {
       return username;
   }
 
   public void setUsername(String username) {
       this.username = username;
   }
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
}