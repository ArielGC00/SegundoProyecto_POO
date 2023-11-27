
package logicadenegocios;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * La clase <code>ValidacionGeneral</code> extiende la clase abstracta <code>Validacion</code> y proporciona
 * validaciones específicas para entradas que deben contener únicamente letras de la A a la Z (sin la letra ñ).
 *
 * @author Ariel Gomez y Marco Perez
 */
public class ValidacionGeneral extends Validacion{
    // Expresión regular para validar letras de la A a la Z sin la letra ñ
    private static final String PATRON_TELEFONICO = "^[A-Za-z\\s*]+$";
    
    /**
     * Valida la entrada específica para el cifrado de letras.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
    @Override
    public boolean validarEspecificoCifrado(String input,Interfaz vista) {
        if (!Pattern.matches(PATRON_TELEFONICO, input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser unicamente las letras de la A a la Z, sin la ñ");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
    
    /**
     * Valida la entrada específica para el descifrado letras.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
    @Override
    public boolean validarEspecificoDescifrado(String input, Interfaz vista) {
        if (!Pattern.matches(PATRON_TELEFONICO, input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser unicamente las letras de la A a la Z, sin la ñ");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
}
