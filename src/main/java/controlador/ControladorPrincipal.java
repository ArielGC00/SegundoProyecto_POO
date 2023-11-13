
package controlador;

/**
 *
 * @author Ariel Gomez y Marco perez
 */

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

        cifradoController = switch (tipoCifrado) {
            case "César" -> new CifradoCesarController(vista);
            case "Llave" -> new CifradoLlaveController(vista);
            case "inverso" -> new CifradoInversoController(vista);
            case "Mensaje"-> new CifradoMensajeInversoController(vista);
            case "Código telefónico" -> new CifradoTelefonoController(vista);
            default -> null;
        }; // Manejar otro tipo de cifrado si es necesario

        if (cifradoController != null) {
            cifradoController.aplicarAlgoritmo();
        }
    }

    private String getTipoCifradoSeleccionado() {
        return (String) vista.getOpcionTipoCifrado().getSelectedItem();
    }
}
