
package logicadenegocios;

import javax.swing.JOptionPane;
import vistas.Interfaz;

/**
 *
 * La clase abstracta <code>Validacion</code> proporciona métodos para validar diversas condiciones en las entradas,
 * como la presencia de valores no vacíos y la conformidad con patrones específicos, como números y espacios.
 * Además, contiene métodos abstractos que deben ser implementados por las subclases para realizar validaciones
 * específicas para cada tipo de cifrado.
 * 
 * @author Ariel Gomez y Marco Perez
 */
public abstract class Validacion {
    /**
     * Valida que la entrada no esté vacía.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada no está vacía, false si lo está.
     */
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
    
  

   /**
     * Método abstracto que debe ser implementado por las subclases para realizar validaciones específicas
     * al cifrar un mensaje.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */ 
    public abstract boolean validarEspecificoCifrado(String input,Interfaz vista);
    /**
     * Método abstracto que debe ser implementado por las subclases para realizar validaciones específicas
     * al descifrar un mensaje.
     *
     * @param input La entrada a validar.
     * @param vista La interfaz asociada.
     * @return true si la entrada es válida, false si no lo es.
     */
    public abstract boolean validarEspecificoDescifrado(String input,Interfaz vista);
}
