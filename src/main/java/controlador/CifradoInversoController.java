
package controlador;
import vistas.Interfaz;
import logicadenegocios.CifradoInverso;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoInversoController {
    private final CifradoInverso cifrador;
    public Interfaz vista;

    public CifradoInversoController(Interfaz vista) {
        this.cifrador = new CifradoInverso();
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
