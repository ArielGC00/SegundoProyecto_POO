
package controlador;
import vistas.Interfaz;
import logicadenegocios.CifradoAES;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoAESController {
    private final CifradoAES cifrador;
    public Interfaz vista;

    public CifradoAESController(Interfaz vista) {
        this.cifrador = new CifradoAES();
        this.vista=vista;
    }

    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            System.out.println(accion+ " mensaje original:"+mensajeOriginal);
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            System.out.println("mensaje cifrado:"+mensajeDescifrado);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
}
