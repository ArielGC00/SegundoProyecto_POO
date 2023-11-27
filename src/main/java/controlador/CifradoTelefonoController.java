
package controlador;

/**
 * * La clase <code>CifradoTelefonoController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado de teléfono en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoTelefono}.
 *
 * @author Ariel Gmez y Marco Perez
 */
import logicadenegocios.CifradoTelefono;
import vistas.Interfaz;


public class CifradoTelefonoController{
    private final CifradoTelefono cifrador;
    private Interfaz vista;
    /**
    * Construye un <code>CifradoTelefonoController</code> con la instancia de la interfaz
    * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoTelefono} para realizar
    * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado de teléfono.
    *
    * @param vista La interfaz gráfica asociada con este controlador.
    */
    public CifradoTelefonoController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoTelefono();
    }
    /**
     * Aplica el algoritmo de cifrado de teléfono al mensaje proporcionado en la interfaz gráfica.
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
