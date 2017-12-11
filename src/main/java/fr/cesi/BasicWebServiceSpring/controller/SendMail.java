/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  */
package fr.cesi.BasicWebServiceSpring.controller;

import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    
    
    public static void SendMailInit(String mail, String mdp){
          System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "zmail.feeder.fr";
	    String emailID = mail;
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    sendEmail(session, emailID,"Idoine demande de nouveau mot de passe", "Votre nouveau mot de passe est : " +mdp+ ""); 
            
            
    }
    
    public static void sendEmail(Session session, String toEmail, String subject, String body){
  
    
    try
    {
    MimeMessage msg = new MimeMessage(session);
    //set message headers
    msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
    msg.addHeader("format", "flowed");
    msg.addHeader("Content-Transfer-Encoding", "8bit");
    
    msg.setFrom(new InternetAddress("Idoine@Idoine.fr", "Idoine"));
    
    msg.setReplyTo(InternetAddress.parse("Idoine@domaine.fr", false));
    
    msg.setSubject(subject, "UTF-8");
    
    msg.setText(body, "UTF-8");
    
    msg.setSentDate(new Date());
    
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    System.out.println("Message is ready");
    Transport.send(msg);
    
    System.out.println("EMail Sent Successfully!!");
    }
    catch (Exception e) {
    e.printStackTrace();
    }
    } 
  
    
      
        
}
   

