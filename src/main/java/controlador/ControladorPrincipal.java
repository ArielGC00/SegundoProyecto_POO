
package controlador;

/**
 *
 * @author Ariel Gomez y Marco perez
 */
import logicadenegocios.CifradoCesar;
import logicadenegocios.CifradoLlave;
import vistas.Interfaz;

public class ControladorPrincipal {

    private CifradoController cifradoController;
    private Interfaz vista;

    public ControladorPrincipal(Interfaz vista) {
        this.vista = vista;
        configurarListeners(vista);
    }

    private void configurarListeners(Interfaz vista) {
        vista.getBotonAplicarAlgoritmo().addActionListener(e -> aplicarAlgoritmo());
    }

    private void aplicarAlgoritmo() {
        String tipoCifrado = getTipoCifradoSeleccionado();

        if (tipoCifrado.equals("César")) {
            cifradoController = new CifradoCesarController(vista);
        } else if (tipoCifrado.equals("Llave")) {
            cifradoController = new CifradoLlaveController(vista);
        } else {
            // Manejar otro tipo de cifrado si es necesario
            cifradoController = null;
        }

        if (cifradoController != null) {
            cifradoController.aplicarAlgoritmo();
        }
    }

    private String getTipoCifradoSeleccionado() {
        return (String) vista.getOpcionTipoCifrado().getSelectedItem();
    }
}
