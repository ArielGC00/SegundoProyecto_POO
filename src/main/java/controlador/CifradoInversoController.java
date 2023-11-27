/**
 * La clase <code>CifradoInversoController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado inverso en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoInverso}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import vistas.Interfaz;
import logicadenegocios.CifradoInverso;

public class CifradoInversoController {
    private final CifradoInverso cifrador;
    public Interfaz vista;

    /**
     * Construye un <code>CifradoInversoController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoInverso} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado inverso.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoInversoController(Interfaz vista) {
        this.cifrador = new CifradoInverso();
        this.vista = vista;
    }

    /**
     * Aplica el algoritmo de cifrado inverso al mensaje proporcionado en la interfaz gráfica.
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
