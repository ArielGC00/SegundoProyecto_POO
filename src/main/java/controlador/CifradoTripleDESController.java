
package controlador;

/**
 * La clase <code>CifradoTripleDESController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado Triple DES en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoTripleDES}.
 * 
 * @author Ariel Gomez y Marco Perez
 */
import logicadenegocios.CifradoTripleDES;
import vistas.Interfaz;

public class CifradoTripleDESController {
    private final CifradoTripleDES cifrador;
    private Interfaz vista;
    /**
     * Construye un <code>CifradoTripleDESController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoTripleDES} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado Triple DES.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoTripleDESController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoTripleDES();
    }
     /**
     * Aplica el algoritmo de cifrado Triple DES al mensaje proporcionado en la interfaz gráfica.
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
