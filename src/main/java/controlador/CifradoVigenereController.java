/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import javax.swing.JOptionPane;
import vistas.Interfaz;
import logicadenegocios.CifradoVigenere;
import logicadenegocios.Validacion;
import logicadenegocios.ValidacionGeneral;

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
            if (nuevaClave == null || nuevaClave.isEmpty()||validarNumerosDeDosDigitos(nuevaClave,vista)==false) {
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
    
    /**
    * Método para validar que la entrada sea un número de dos dígitos (entre 10 y 99).
    * 
    * @param input La entrada a validar.
    * @param vista La interfaz asociada.
    * @return true si la entrada es válida, false si no lo es.
    */
   public boolean validarNumerosDeDosDigitos(String input, Interfaz vista) {
       try {
           // Intentar convertir la entrada a un entero
           int numero = Integer.parseInt(input);

           // Validar que esté en el rango de 10 a 99
           if (numero >= 10 && numero <= 99) {
               return true;
           } else {
               JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser un número de dos dígitos (entre 10 y 99).");
               vista.getSalidaText().setText(" ");
               return false;
           }
       } catch (NumberFormatException e) {
           // Capturar la excepción si no se puede convertir a entero
           JOptionPane.showMessageDialog(vista, "Error: La entrada debe ser un número válido.");
           vista.getSalidaText().setText(" ");
           return false;
       }
   }
}
