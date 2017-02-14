package Mail;

import models.Car;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by bse71 on 14.02.2017.
 */
public class MyAppender extends AppenderSkeleton {
    private static final String STANDART_TOPIC = "У нас логи, милорд!";
    private static final String DESTINATION_EMAIL = "bsesie71@gmail.com";
    private static final String PORT = "587";
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String FROM_EMAIL = "innopolistest@gmail.com";
    private static final String PASSWORD = "testinnopolis";
    private static final int FILE_LENGTH = 1024;

    @Override
    protected void append(LoggingEvent event) {
        File file = new File("applog.txt");
        if (file.length() < FILE_LENGTH) return;
        String zipFile = Zipper.toZip("applog.txt", FILE_LENGTH);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_SERVER);
        props.put("mail.smtp.port", PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(DESTINATION_EMAIL));
            message.setSubject(STANDART_TOPIC);
            message.setText(layout.format(event));


            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(zipFile);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(zipFile);
            System.out.println(zipFile);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);

            if (!file.exists()) return;
            try(PrintWriter pw = new PrintWriter(new FileWriter(file), false)){
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
