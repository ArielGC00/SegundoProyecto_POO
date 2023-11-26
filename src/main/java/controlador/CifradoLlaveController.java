
package controlador;

import javax.swing.JOptionPane;
import logicadenegocios.CifradoLlave;
import logicadenegocios.ValidacionGeneral;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */

public class CifradoLlaveController {
    public Interfaz vista;
    private final CifradoLlave cifrador;
    public ValidacionGeneral ValidacionGeneral=new ValidacionGeneral();
    public CifradoLlaveController(Interfaz vista) {
        this.vista=vista;
        this.cifrador = new CifradoLlave();
    }
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if ("Llave".equals(vista.getOpcionTipoCifrado().getSelectedItem())) {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String nuevaClave = JOptionPane.showInputDialog(vista, "Ingrese la clave para el cifrado por llave:");

            // Validar si el usuario canceló o ingresó una clave válida
            if (nuevaClave == null || nuevaClave.isEmpty()||ValidacionGeneral.validarEspecificoCifrado(nuevaClave, vista)==false) {
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

