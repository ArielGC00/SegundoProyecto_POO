
package logicadenegocios;

import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public abstract class Validacion {

    public boolean validar(String input,Interfaz vista) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada no puede estar vacía.");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract boolean validarEspecificoCifrado(String input,Interfaz vista);
    
    public abstract boolean validarEspecificoDescifrado(String input,Interfaz vista);
}
