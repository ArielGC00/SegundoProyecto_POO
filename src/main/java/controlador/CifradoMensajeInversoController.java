/**
 * La clase <code>CifradoMensajeInversoController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado de mensaje inverso en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoMensajeInverso}.
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import logicadenegocios.CifradoMensajeInverso;
import vistas.Interfaz;

public class CifradoMensajeInversoController {
    private final CifradoMensajeInverso cifrador;
    public Interfaz vista;

    /**
     * Construye un <code>CifradoMensajeInversoController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoMensajeInverso} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de mensaje inverso.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoMensajeInversoController(Interfaz vista) {
        this.vista = vista;
        this.cifrador = new CifradoMensajeInverso();
    }

    /**
     * Aplica el algoritmo de cifrado de mensaje inverso al mensaje proporcionado en la interfaz gráfica.
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
