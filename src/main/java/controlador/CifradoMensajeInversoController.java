
package controlador;

import logicadenegocios.CifradoMensajeInverso;
import vistas.Interfaz;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoMensajeInversoController{
    private final CifradoMensajeInverso cifrador;
    public Interfaz vista;

    public CifradoMensajeInversoController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoMensajeInverso();
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
