package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.sql.SQLOutput;
import java.util.Properties;
public class GMailSender {
 public Boolean SendEmail(String to,String from,String subject,String text){
     boolean flag=false;

     //logic

     //SMTP Server details
     Properties prop=new Properties();
     prop.put("mail.smtp.auth",true);
     prop.put("mail.smtp.starttls.enable",true);
     prop.put("mail.smtp.port","587");
     prop.put("mail.smtp.host","smtp.gmail.com");

     String username="riteshghatge5555";
     String password="yxwa yzwq gkfr nery";

     //session coding
     Session session=Session.getInstance(prop,new Authenticator(){
         @Override
         protected PasswordAuthentication getPasswordAuthentication(){
             return new PasswordAuthentication(username,password);
         }
     });

     //MimeMessage Code to develop matter of the Email
     try{

          Message msg=new MimeMessage(session);
          msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
          msg.setFrom(new InternetAddress(from));
          msg.setSubject(subject);
         // msg.setContent(text,"text/html");
          flag=true;

          MimeBodyPart mssg=new MimeBodyPart();
          String html="<html><head><style>" +
                  ".main{ position:relative; margin:auto; top:2vh; justify-content:center;" +
                  "text-align:center; font-size:23px;} "+
                  "</style></head><body>" +
                  "<div class=\"main\">"+
                  "<h1></h1><br> <p style=\"color:red;\"></html>" +
                  "You have recived OTP for login into abc "+"</p>"
                  +"<img src=\"cid:image1\"style=\"margin-left:25%;\">";
          mssg.setContent(html,"text/html");
          MimeBodyPart image=new MimeBodyPart();
          image.attachFile("D:/WebPages/drive_Clone/images/profile.png");
          image.setContentID("<image1>");

          Multipart m=new MimeMultipart();
          m.addBodyPart(mssg);
          m.addBodyPart(image);

          msg.setContent(m);
         Transport.send(msg);
     }
     catch(Exception e){
         e.printStackTrace();
     }


     return flag;
 }
}
