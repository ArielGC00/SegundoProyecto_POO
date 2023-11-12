
package controlador;

import logicadenegocios.CifradoLlave;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */

public class CifradoLlaveController extends CifradoController {

    private final CifradoLlave cifrador;

    public CifradoLlaveController(Interfaz vista) {
        super(vista);
        this.cifrador = new CifradoLlave("tango");
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

