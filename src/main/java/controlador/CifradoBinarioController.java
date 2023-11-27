/**
 * La clase <code>CifradoBinarioController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado binario en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoBinario}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
package controlador;

import vistas.Interfaz;
import logicadenegocios.CifradoBinario;

public class CifradoBinarioController {

    private final CifradoBinario cifrador;
    public Interfaz vista;

    /**
     * Construye un <code>CifradoBinarioController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoBinario} para realizar
     * operaciones de cifrado y descifrado.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoBinarioController(Interfaz vista) {
        this.cifrador = new CifradoBinario();
        this.vista = vista;
    }

    /**
     * Aplica el algoritmo de cifrado binario al mensaje proporcionado en la interfaz gráfica.
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
