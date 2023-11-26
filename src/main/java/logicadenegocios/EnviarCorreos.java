
package logicadenegocios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        // Verificar el correo con la API emailable antes de enviar
        if (verificarCorreo(destinatario)) {
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
        } else {
            System.out.println("Correo no válido. Verificación fallida.");
        }
    }

    private boolean verificarCorreo(String correo) {
        // URL de la API emailable para verificar correos electrónicos
        String apiUrl = "https://api.emailable.com/v1/verify?email=mapp1803@gmail.com&api_key=live_4ca69232cf6efc191f35&email=" + correo;

        try {
            // Realizar una solicitud HTTP GET a la API emailable
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtener la respuesta de la API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // Analizar la respuesta JSON de la API emailable (puedes adaptar esto según el formato de la respuesta)
            // En este ejemplo, asumimos que la API devuelve un campo "valid" que indica si el correo es válido
            // Puedes ajustar esto según la documentación de la API emailable
            // Gson library: https://github.com/google/gson
            // JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            // boolean isValid = jsonObject.get("valid").getAsBoolean();

            // Devolver true si el correo es válido, false si no lo es
            return response.toString().contains("\"state\":\"deliverable\""); // Reemplaza esto con la lógica real de tu API
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo básico de errores, puedes ajustarlo según tus necesidades
        }
    }
}
