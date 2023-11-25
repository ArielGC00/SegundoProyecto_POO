
package controlador;
import logicadenegocios.CifradoCesar;
import vistas.Interfaz;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoCesarController {
    public Interfaz vista;
    private final CifradoCesar cifrador;

    public CifradoCesarController(Interfaz vista) {
        this.cifrador = new CifradoCesar();
        this.vista=vista;
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