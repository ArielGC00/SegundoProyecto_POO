
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vistas.Interfaz;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class AbrirArchivoController {
    private final Interfaz interfaz;

    public AbrirArchivoController(Interfaz interfaz) {
        this.interfaz = interfaz;
        init();
    }

    private void init() {
        interfaz.getBtnAbrirTxt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivo();
            }
        });
    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(interfaz);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String contenido = leerArchivo(fileChooser.getSelectedFile().getPath());
                interfaz.getEntradaText().setText(contenido);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(interfaz, "Error al abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String leerArchivo(String path) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
}
