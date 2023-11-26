
package logicadenegocios;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class ValidacionGeneral extends Validacion{
    // Expresión regular para validar letras de la A a la Z sin la letra ñ
    private static final String PATRON_TELEFONICO = "^[A-Za-z\\s*]+$";
    @Override
    public boolean validarEspecificoCifrado(String input,Interfaz vista) {
        if (!Pattern.matches(PATRON_TELEFONICO, input)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser unicamente las letras de la A a la Z, sin la ñ");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
    


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
