package logicadenegocios;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *La clase <code>ValidacionAscii</code> extiende la clase abstracta <code>Validacion</code> y proporciona
 * validaciones específicas para entradas relacionadas con caracteres ASCII. Verifica que la entrada contenga
 * únicamente caracteres ASCII.
 * 
 * @author Ariel Gomez y Marco Perez
 */
public class ValidacionAscii extends Validacion {
    /**
     * Valida la entrada específica para el cifrado y descifrado ASCII.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
    @Override
    public boolean validarEspecificoCifrado(String input, Interfaz vista) {
        // Validación específica para el cifrado
        return validarAscii(input, vista);
    }
    /**
     * Valida la entrada específica para el descifrado ASCII.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
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
