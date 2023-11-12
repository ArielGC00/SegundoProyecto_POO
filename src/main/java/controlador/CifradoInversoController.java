
package controlador;
import vistas.Interfaz;
import logicadenegocios.CifradoInverso;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoInversoController extends CifradoController {
    private final CifradoInverso cifrador;

    public CifradoInversoController(Interfaz vista) {
        super(vista);
        this.cifrador = new CifradoInverso();
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
