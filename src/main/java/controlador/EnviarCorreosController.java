/**
 * La clase EnviarCorreosController es un controlador que gestiona la funcionalidad
 * de enviar correos electrónicos desde una interfaz grafica. Está asociada con las clases
 
 * 
 * @author Ariel Gomez
 * @version 1.0
 */
package controlador;

import logicadenegocios.EnviarCorreos;
import vistas.EnviarCorreoInterfaz;
import vistas.Interfaz;

public class EnviarCorreosController {

    private final EnviarCorreos enviador;
    private final Interfaz vista;
    private final EnviarCorreoInterfaz correoInterfaz;
    /**
     * Construye un <code>EnviarCorreosController</code> con las instancias de la interfaz principal y
     * la interfaz de envío de correos electrónicos proporcionadas. Utiliza una instancia de
     * {@link logicadenegocios.EnviarCorreos} para gestionar el envío de correos electrónicos.
     *
     * @param vista La interfaz gráfica principal asociada con este controlador.
     * @param correoInterfaz La interfaz grafica de envío de correos electrónicos asociada con este controlador.
     */
    public EnviarCorreosController(Interfaz vista, EnviarCorreoInterfaz correoInterfaz) {
        this.enviador = new EnviarCorreos();
        this.vista = vista;
        this.correoInterfaz = correoInterfaz;
        

        configurarListeners();
    }

   /**
     * Abre la ventana de envio de correos electronicos y realiza la accion de enviar el correo.
     * Obtiene el destinatario y el contenido del correo desde las interfaces asociadas y utiliza
     * la instancia de {@link logicadenegocios.EnviarCorreos} para enviar el correo electronico.
     */
    private void abrirVentanaEnviarCorreo() {
        // Obtener el correo del destinatario desde la interfaz de EnviarCorreoInterfaz
        String destinatario = correoInterfaz.getCorreoDestinatario().getText();

        // Obtener el contenido del correo desde la interfaz de la aplicación principal
        String contenidoCorreo = vista.getSalidaText().getText();

        // Enviar el correo
        enviador.enviarCorreo(destinatario, contenidoCorreo);
        System.out.println("Correo enviado con éxito");
    }
    
    /**
     * Configura los listeners necesarios para manejar la interacción del usuario en la interfaz
     * de envio de correos electronicos.
     */
    private void configurarListeners() {
        correoInterfaz.getBotonEnviarCorreo().addActionListener(e -> abrirVentanaEnviarCorreo());
    }

}
