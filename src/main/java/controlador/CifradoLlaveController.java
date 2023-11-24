
package controlador;

import javax.swing.JOptionPane;
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
        this.cifrador = new CifradoLlave();
    }

    @Override
    protected void configurarListeners() {
        vista.getBotonAplicarAlgoritmo().addActionListener(e -> aplicarAlgoritmo());
    }

    @Override
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if ("Llave".equals(vista.getOpcionTipoCifrado().getSelectedItem())) {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String nuevaClave = JOptionPane.showInputDialog(vista, "Ingrese la clave para el cifrado por llave:");

            // Validar si el usuario canceló o ingresó una clave válida
            if (nuevaClave == null || nuevaClave.isEmpty()) {
                // El usuario canceló o no ingresó una clave válida
                JOptionPane.showMessageDialog(vista, "Se canceló el cifrado por llave.");
                return;
            }

            // Actualizar la clave
            cifrador.setClave(nuevaClave);
        }

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            String mensajeDecodificado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDecodificado);
        }
    }

}

