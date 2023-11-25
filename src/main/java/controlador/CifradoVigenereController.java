/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import javax.swing.JOptionPane;
import vistas.Interfaz;
import logicadenegocios.CifradoVigenere;

/**
 *
 * @author Ariel Gmez y Marco Perez
 */

public class CifradoVigenereController {

    private final CifradoVigenere cifrador;
    private Interfaz vista;

    public CifradoVigenereController(Interfaz vista) {
        this.cifrador = new CifradoVigenere();
        this.vista=vista;
    }
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if ("Vigenére".equals(vista.getOpcionTipoCifrado().getSelectedItem())) {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String nuevaClave = JOptionPane.showInputDialog(vista, "Ingrese la clave para el cifrado Vigenère:");

            // Validar si el usuario canceló o ingresó una clave válida
            if (nuevaClave == null || nuevaClave.isEmpty()) {
                // El usuario canceló o no ingresó una clave válida
                JOptionPane.showMessageDialog(vista, "Se canceló el cifrado Vigenère.");
                return;
            }

            // Actualizar la clave
            cifrador.setClave(Integer.parseInt(nuevaClave));
        }

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
}
