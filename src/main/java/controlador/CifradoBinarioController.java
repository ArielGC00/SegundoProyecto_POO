/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vistas.Interfaz;
import logicadenegocios.CifradoBinario;

/**
 *
 * @author Ariel Gomez y Marco perez
 */


public class CifradoBinarioController {

    private final CifradoBinario cifrador;
    public Interfaz vista;

    public CifradoBinarioController(Interfaz vista) {
        this.cifrador = new CifradoBinario();
        this.vista=vista;
    }

    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            System.out.println(accion+ " mensaje original:"+mensajeOriginal);
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            System.out.println("mensaje cifrado:"+mensajeDescifrado);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
}

