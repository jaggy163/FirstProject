import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

public class MailThread extends Thread {
    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;
    public MailThread(String sendToEmail, String mailSubject, String mailText, Properties properties) {
        this.sendToEmail=sendToEmail;
        this.mailSubject=mailSubject;
        this.mailText=mailText;
        this.properties=properties;
    }

    private void init() {
        //объект почтовой сессии
        Session mailSession = (new SessionCreator(properties).createSession());
        mailSession.setDebug(true);
        //создание объекта почтового сообщения
        message = new MimeMessage(mailSession);
        try {
            // загрузка параметров в объект почтового сообщения
            message.setSubject(mailSubject);
            message.setContent(mailText, "text/html");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.init();
        try {
            //Отправка сообщения
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
