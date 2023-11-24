
package controlador;

/**
 *
 * @author Ariel Gomez y Marco perez
 */

import vistas.Interfaz;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorPrincipal {

    private CifradoController cifradoController;
    private Interfaz vista;

    public ControladorPrincipal(Interfaz vista) {
        this.vista = vista;
        configurarListeners(vista);
    }

    private void configurarListeners(Interfaz vista) {
        vista.getBotonAplicarAlgoritmo().addActionListener(e -> aplicarAlgoritmo());
        vista.getBtnAbrirTxt().addActionListener(e -> abrirArchivo());
    }

    private void aplicarAlgoritmo() {
        String tipoCifrado = getTipoCifradoSeleccionado();

        cifradoController = switch (tipoCifrado) {
            case "César" -> new CifradoCesarController(vista);
            case "Llave" -> new CifradoLlaveController(vista);
            case "inverso" -> new CifradoInversoController(vista);
            case "Mensaje"-> new CifradoMensajeInversoController(vista);
            case "Código telefónico" -> new CifradoTelefonoController(vista);
            //case "RSA" -> new CifradoRSAController(vista);
            default -> null;
        }; // Manejar otro tipo de cifrado si es necesario

        if (cifradoController != null) {
            cifradoController.aplicarAlgoritmo();
        }
    }
    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(vista);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                String contenido = leerContenidoArchivo(selectedFile);
                vista.getEntradaText().setText(contenido);
            } catch (IOException e) {
                // Manejar la excepción según tus necesidades
                
            }
        }
    }

    private String leerContenidoArchivo(File file) throws IOException {
        StringBuilder contenido = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append("\n");
        }

        reader.close();
        return contenido.toString();
    }

    private String getTipoCifradoSeleccionado() {
        return (String) vista.getOpcionTipoCifrado().getSelectedItem();
    }
}
