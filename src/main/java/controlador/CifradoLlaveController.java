/**
 * La clase <code>CifradoLlaveController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado por llave en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoLlave}. También incluye la validación de la clave mediante
 * la clase {@link logicadenegocios.ValidacionGeneral}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import javax.swing.JOptionPane;
import logicadenegocios.CifradoLlave;
import logicadenegocios.ValidacionGeneral;
import vistas.Interfaz;

public class CifradoLlaveController {
    public Interfaz vista;
    private final CifradoLlave cifrador;
    public ValidacionGeneral ValidacionGeneral = new ValidacionGeneral();

    /**
     * Construye un <code>CifradoLlaveController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoLlave} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado por llave.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoLlaveController(Interfaz vista) {
        this.vista = vista;
        this.cifrador = new CifradoLlave();
    }

    /**
     * Aplica el algoritmo de cifrado por llave al mensaje proporcionado en la interfaz gráfica.
     * El tipo de acción (codificar o descifrar) se determina a través del elemento seleccionado
     * en el combo box de la interfaz.
     * Si el tipo de cifrado es "Llave", solicita al usuario ingresar la clave y la valida antes de
     * proceder con la operación de cifrado o descifrado.
     * Si la acción es "Codificar", muestra el mensaje cifrado en el área de salida.
     * Si la acción es "Descifrar", muestra el mensaje descifrado en el área de salida.
     */
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if ("Llave".equals(vista.getOpcionTipoCifrado().getSelectedItem())) {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String nuevaClave = JOptionPane.showInputDialog(vista, "Ingrese la clave para el cifrado por llave:");

            // Validar si el usuario canceló o ingresó una clave válida
            if (nuevaClave == null || nuevaClave.isEmpty() || ValidacionGeneral.validarEspecificoCifrado(nuevaClave, vista) == false) {
                // El usuario canceló o no ingresó una clave válida
                JOptionPane.showMessageDialog(vista, "Se canceló el cifrado por llave.");
                return;
            }

            // Actualizar la clave
            cifrador.setClave(nuevaClave);
        }

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            String mensajeDecodificado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDecodificado);
        }
    }
}


