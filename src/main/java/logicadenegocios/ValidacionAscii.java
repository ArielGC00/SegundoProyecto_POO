package logicadenegocios;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class ValidacionAscii extends Validacion {

    @Override
    public boolean validarEspecificoCifrado(String input, Interfaz vista) {
        // Validación específica para el cifrado
        return validarAscii(input, vista);
    }

    @Override
    public boolean validarEspecificoDescifrado(String input, Interfaz vista) {
        // Validación específica para el descifrado
        return validarAscii(input, vista);
    }

    private boolean validarAscii(String input, Interfaz vista) {
        // Validar que la entrada contenga solo caracteres ASCII
        if (!Pattern.matches("[\\x00-\\x7F]+", input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe contener solo caracteres ASCII.");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
}
