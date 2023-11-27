
package controlador;
import javax.swing.JOptionPane;
import vistas.Interfaz;
import logicadenegocios.CifradoVigenere;

/**
 ** La clase <code>CifradoVigenereController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado Vigenère en una interfaz grafica. Esta asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoVigenere}.
 *
 * @author Ariel Gmez y Marco Perez
 */

public class CifradoVigenereController {

    private final CifradoVigenere cifrador;
    private Interfaz vista;
    /**
     * Construye un <code>CifradoVigenereController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoVigenere} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado Vigenère.
     *
     * @param vista La interfaz grafica asociada con este controlador.
     */

    public CifradoVigenereController(Interfaz vista) {
        this.cifrador = new CifradoVigenere();
        this.vista=vista;
    }
    /**
     * Aplica el algoritmo de cifrado Vigenère al mensaje proporcionado en la interfaz grafica.
     * El tipo de acción (codificar o descifrar) se determina a través del elemento seleccionado
     * en el combo box de la interfaz. Si el tipo de cifrado es "Vigenère", solicita al usuario
     * ingresar la clave y la valida utilizando el método {@link #validarNumerosDeDosDigitos(String, Interfaz)}.
     * Si la acción es "Codificar", muestra el mensaje cifrado en el area de salida.
     * Si la acción es "Descifrar", muestra el mensaje descifrado en el area de salida.
     */
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if ("Vigenére".equals(vista.getOpcionTipoCifrado().getSelectedItem())) {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String nuevaClave = JOptionPane.showInputDialog(vista, "Ingrese la clave para el cifrado Vigenère:");
            
            // Validar si el usuario canceló o ingresó una clave valida
            if (nuevaClave == null || nuevaClave.isEmpty()||validarNumerosDeDosDigitos(nuevaClave,vista)==false) {
                // El usuario canceló o no ingresó una clave valida
                JOptionPane.showMessageDialog(vista, "Se canceló el cifrado Vigenère.");
                return;
            }

            // Actualizar la clave
            cifrador.setClave(nuevaClave);
        }

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
    
    /**
    * Método para validar que la entrada sea un número de dos dígitos (entre 10 y 99).
    * 
    * @param input La entrada a validar.
    * @param vista La interfaz asociada.
    * @return true si la entrada es valida, false si no lo es.
    */
   public boolean validarNumerosDeDosDigitos(String input, Interfaz vista) {
       try {
           // Intentar convertir la entrada a un entero
           int numero = Integer.parseInt(input);

           // Validar que esté en el rango de 10 a 99
           if (numero >= 10 && numero <= 99) {
               return true;
           } else {
               JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser un número de dos dígitos (entre 10 y 99).");
               vista.getSalidaText().setText(" ");
               return false;
           }
       } catch (NumberFormatException e) {
           // Capturar la excepción si no se puede convertir a entero
           JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser un número válido.");
           vista.getSalidaText().setText(" ");
           return false;
       }
   }
}
