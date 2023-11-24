/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import controlador.CifradoController;
import vistas.Interfaz;
import logicadenegocios.CifradoBinario;

/**
 *
 * @author Ariel Gomez y Marco perez
 */


public class CifradoBinarioController extends CifradoController {

    private final CifradoBinario cifrador;

    public CifradoBinarioController(Interfaz vista) {
        super(vista);
        this.cifrador = new CifradoBinario();
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
            String mensajeDescifrado = cifrador.descifrar(mensajeOriginal);
            vista.getSalidaText().setText(mensajeDescifrado);
        }
    }
}

