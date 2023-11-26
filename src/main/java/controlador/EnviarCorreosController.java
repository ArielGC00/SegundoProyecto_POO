/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logicadenegocios.EnviarCorreos;
import vistas.EnviarCorreoInterfaz;
import vistas.Interfaz;

public class EnviarCorreosController {

    private final EnviarCorreos enviador;
    private final Interfaz vista;
    private final EnviarCorreoInterfaz correoInterfaz;

    public EnviarCorreosController(Interfaz vista, EnviarCorreoInterfaz correoInterfaz) {
        this.enviador = new EnviarCorreos();
        this.vista = vista;
        this.correoInterfaz = correoInterfaz;
        

        configurarListeners();
    }

   
    private void abrirVentanaEnviarCorreo() {
        // Obtener el correo del destinatario desde la interfaz de EnviarCorreoInterfaz
        String destinatario = correoInterfaz.getCorreoDestinatario().getText();

        // Obtener el contenido del correo desde la interfaz de la aplicación principal
        String contenidoCorreo = vista.getSalidaText().getText();

        // Enviar el correo
        enviador.enviarCorreo(destinatario, contenidoCorreo);
        System.out.println("Correo enviado con éxito");
    }
    
    private void configurarListeners() {
        correoInterfaz.getBotonEnviarCorreo().addActionListener(e -> abrirVentanaEnviarCorreo());
    }

}
