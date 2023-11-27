/**
 * La clase <code>CifradoCesarController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado César en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoCesar}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import logicadenegocios.CifradoCesar;
import vistas.Interfaz;

public class CifradoCesarController {
    public Interfaz vista;
    private final CifradoCesar cifrador;

    /**
     * Construye un <code>CifradoCesarController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoCesar} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de Cifrado César.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoCesarController(Interfaz vista) {
        this.cifrador = new CifradoCesar();
        this.vista = vista;
    }

    /**
     * Aplica el algoritmo de cifrado César al mensaje proporcionado en la interfaz gráfica.
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
            String mensajeDecodificado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDecodificado);
        }
    }
}
