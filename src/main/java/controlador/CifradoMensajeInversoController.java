
package controlador;

import logicadenegocios.CifradoMensajeInverso;
import vistas.Interfaz;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoMensajeInversoController extends CifradoController{
    private final CifradoMensajeInverso cifrador;

    public CifradoMensajeInversoController(Interfaz vista) {
        super(vista);
        this.cifrador = new CifradoMensajeInverso();
    }

    @Override
    protected void configurarListeners() {
        vista.getBotonAplicarAlgoritmo().addActionListener(e -> aplicarAlgoritmo());
    }

    @Override
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
