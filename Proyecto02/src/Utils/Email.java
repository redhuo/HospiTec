package Utils;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Email {
	String correo;
	String archivo;
	String numeroPedido;
    public Email(String correo)  {
    	this.correo = correo;

    }
    
    public void enviar() throws MessagingException {
    	   String host = "smtp.gmail.com";
           String Password = "rapiexpress1234";
           String from = "rapiexpressprueba@gmail.com";
           String toAddress = this.correo;
           String filename = this.archivo;
           // Get system properties
           Properties props = System.getProperties();
           props.put("mail.smtp.host", host);
           props.put("mail.smtps.auth", "true");
           props.put("mail.smtp.starttls.enable", "true");
           Session session = Session.getInstance(props, null);

           MimeMessage message = new MimeMessage(session);

           message.setFrom(new InternetAddress(from));

           message.setRecipients(Message.RecipientType.TO, toAddress);

           message.setSubject("Cancelacion de Cita");

           BodyPart messageBodyPart = new MimeBodyPart();

           messageBodyPart.setText("Has Cancelado una cita");

           Multipart multipart = new MimeMultipart();

           multipart.addBodyPart(messageBodyPart);

           message.setContent(multipart);

           try {
               Transport tr = session.getTransport("smtps");
               tr.connect(host, from, Password);
               tr.sendMessage(message, message.getAllRecipients());
               System.out.println("Mail Sent Successfully");
               tr.close();

           } catch (SendFailedException sfe) {

               System.out.println(sfe);
           }
       }
       

    /*public static void main(String args[]) throws MessagingException{
        Email sm = new Email();
        sm.enviar();
    }*/
}