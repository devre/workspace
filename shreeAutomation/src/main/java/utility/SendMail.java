package utility;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail 
{
	public static void main(String[] args) {

		final String username = "DEVREBC@gmail.com";
		final String password = "kHUSHI2002";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		  });

		try {

		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress("from-email@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse("DEVRESHRIKANT@gmail.com"));
		    message.setSubject("Testing Subject");
		    message.setText("Dear Mail Crawler,"
		        + "\n\n No spam to my email, please!");

		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();		    
		    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
		    
		    String filename = "C://Development//workspace//shreeAutomation//output//index.html";
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  



		    MimeMultipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  

		     message.setContent(multipart );  


		    Transport.send(message);

		    System.out.println("Done");

		} catch (MessagingException e) {
		    throw new RuntimeException(e);
		}
	}
}
