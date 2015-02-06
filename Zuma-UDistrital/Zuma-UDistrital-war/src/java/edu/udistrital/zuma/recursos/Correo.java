package edu.udistrital.zuma.recursos;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jhon
 */
public class Correo {
    
    
    private static final String PATRON = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public String NUMEROS = "0123456789";
    public String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static boolean validarCorreo(String correoValidar) {
        Pattern patron = Pattern.compile(PATRON);
        Matcher matcher = patron.matcher(correoValidar);
        return matcher.matches();
    }

    public String generarClave(int length) {
        String clave = "";
        for (int i = 0; i < length; i++) {
            clave += (MAYUSCULAS.charAt((int) (Math.random() * MAYUSCULAS.length())));
        }
        return clave;
    }
    
    public static boolean enviarCorreo(String text, String mailFrom, String mailTo, String subject){
        try {
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.socketFactory.port", "587");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.auth", "true");

            Authenticator auth = new MyAuthenticator();
            Session smtpSession = Session.getInstance(props, auth);
            smtpSession.setDebug(false);

            MimeMessage message = new MimeMessage(smtpSession);
            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            final String encoding = "UTF-8";
            message.setSubject(subject, encoding);
            message.setText(text, encoding);
            Transport.send(message);
            System.out.println("Se envio el correo.......");
            return true;
        } catch (MessagingException e) {
            System.out.println("exception ----- "+e);
            return false;
        }
    }

    static class MyAuthenticator extends Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = "jfredypuentes@gmail.com";
            String password = ".JhonFredy@2014";
            return new PasswordAuthentication(username, password);
        }
    }
}
