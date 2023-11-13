
package controlador;

/**
 *
 * @author Ariel Gmez y Marco Perez
 */
import logicadenegocios.CifradoTelefono;
import vistas.Interfaz;

public class CifradoTelefonoController extends CifradoController{
    private final CifradoTelefono cifrador;

    public CifradoTelefonoController(Interfaz vista) {
        super(vista);
        this.cifrador = new CifradoTelefono();
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
