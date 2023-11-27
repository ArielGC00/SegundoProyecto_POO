/**
 * La clase <code>CifradoAESController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado AES en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoAES}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import vistas.Interfaz;
import logicadenegocios.CifradoAES;

public class CifradoAESController {
    private final CifradoAES cifrador;
    public Interfaz vista;

    /**
     * Construye un <code>CifradoAESController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoAES} para realizar
     * operaciones de cifrado y descifrado.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoAESController(Interfaz vista) {
        this.cifrador = new CifradoAES();
        this.vista = vista;
    }

    /**
     * Aplica el algoritmo de cifrado AES al mensaje proporcionado en la interfaz gráfica.
     * El tipo de acción (codificar o descifrar) se determina a través del elemento seleccionado
     * en el combo box de la interfaz.
     * Si la acción es "Codificar", muestra el mensaje cifrado en el área de salida.
     * Si la acción es "Descifrar", muestra el mensaje descifrado en el área de salida.
     */
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            System.out.println(accion + " mensaje original:" + mensajeOriginal);
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            System.out.println("mensaje cifrado:" + mensajeDescifrado);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
}
