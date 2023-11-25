
package controlador;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
import logicadenegocios.CifradoTripleDES;
import vistas.Interfaz;

public class CifradoTripleDESController {
    private final CifradoTripleDES cifrador;
    private Interfaz vista;

    public CifradoTripleDESController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoTripleDES();
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
