
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
    /**
     * Método para validar que la entrada contenga solo números y espacios.
     * 
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
    public boolean validarNumerosYEspacios(String input, Interfaz vista) {
        // Expresión regular para validar números y espacios
        String patron = "^[0-9\\s]+$";

        // Validar usando la expresión regular
        if (!input.matches(patron)) {
            JOptionPane.showMessageDialog(vista, "Error: La entrada debe contener únicamente números y espacios.");
            vista.getSalidaText().setText(" ");
            return false;
        }
        return true;
    }
    
  

    // Método abstracto que debe ser implementado por las subclases
    public abstract boolean validarEspecificoCifrado(String input,Interfaz vista);
    
    public abstract boolean validarEspecificoDescifrado(String input,Interfaz vista);
}
