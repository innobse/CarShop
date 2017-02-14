package Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

    public class MailSender {

        public static void main(String[] args) {
/*
            final String username = "spam@bse71.ru";
            final String password = "25467789";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.yandex.ru");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("from_spam@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("y.penkov.stc@innopolis.ru"));
                message.setSubject("Testing Subject");
                message.setText("Dear Mail Crawler,"
                        + "\n\n No spam to my email, please!");

                Transport.send(message);

                System.out.println("Done");

            } catch (javax.mail.MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
        }}
