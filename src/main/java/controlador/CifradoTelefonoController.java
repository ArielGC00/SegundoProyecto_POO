
package controlador;

/**
 *
 * @author Ariel Gmez y Marco Perez
 */
import logicadenegocios.CifradoTelefono;
import vistas.Interfaz;

public class CifradoTelefonoController{
    private final CifradoTelefono cifrador;
    private Interfaz vista;

    public CifradoTelefonoController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoTelefono();
    }

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
