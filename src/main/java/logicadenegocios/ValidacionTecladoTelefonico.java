
package logicadenegocios;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * @author josea
 */
public class ValidacionTecladoTelefonico extends Validacion{
    // Expresión regular para validar letras de la A a la Z sin la letra ñ
    private static final String PATRON_TELEFONICO = "^[A-Za-z\\s*]+$";
    // Expresión regular para validar números, espacios y *
    private static final String PATRON_DESCIFRADO = "^[0-9\\s*]+$";

    @Override
    public boolean validarEspecificoCifrado(String input,Interfaz vista) {
        // Validación específica para el teclado telefónico usando la expresión regular
        if (!Pattern.matches(PATRON_TELEFONICO, input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser unicamente las letras del teclado númerico");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
    


    @Override
    public boolean validarEspecificoDescifrado(String input, Interfaz vista) {
        // Validación específica para el descifrado usando la expresión regular
        if (!Pattern.matches(PATRON_DESCIFRADO, input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser únicamente números, espacios y *.");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
}
