/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase para enviar correos electrónicos.
 * 
 * @author marco P y Ariel G
 */
public class EnviarCorreos {

    public void enviarCorreo(String destinatario, String contenidoCorreo) {
        // Configuración de las propiedades
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia al servidor de correo que estás utilizando
        props.put("mail.smtp.port", "587"); // Puerto SMTP (587 es un puerto común para correo seguro)
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Crea una sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bingocmj2023@gmail.com", "oaxadgsrpkcyyxvd");
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bingocmj2023@gmail.com")); // Reemplaza con tu correo
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario)); // Utiliza el destinatario proporcionado
            message.setSubject("Cifrado y decifrado");
            message.setText(contenidoCorreo);

            // Envío del mensaje
            Transport.send(message);

            System.out.println("Correo enviado con éxito");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
