
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
 * La clase AbrirArchivoController es un controlador que gestiona la
 * funcionalidad de abrir y leer archivos de texto en una interfaz gráfica.
 * Está asociada con la clase {@link vistas.Interfaz}.
 *
 * @author Ariel Gomez y Marco Perez
 * @version 1.0
 */
public class AbrirArchivoController {
    private final Interfaz interfaz;
    
    
    /**
     * Construye un <code>AbrirArchivoController</code> con la instancia de
     * {@link vistas.Interfaz} especificada.
     *
     * @param interfaz La interfaz gráfica asociada con este controlador.
     */ 
    public AbrirArchivoController(Interfaz interfaz) {
        this.interfaz = interfaz;
        init();
    }
    /**
     * Inicializa el controlador configurando el ActionListener para el botón
     * "Abrir" en la interfaz asociada.
     */
    private void init() {
        interfaz.getBtnAbrirTxt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivo();
            }
        });
    }
    /**
     * Abre un cuadro de diálogo para seleccionar un archivo de texto y lee su contenido.
     * Si tiene éxito, el contenido se muestra en el área de texto de la interfaz asociada.
     * Muestra un mensaje de error si se produce una excepción durante el proceso.
     */
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
    /**
     * Lee el contenido del archivo de texto especificado y lo devuelve como una cadena.
     *
     * @param path La ruta del archivo de texto a leer.
     * @return El contenido del archivo de texto como una cadena.
     * @throws IOException Si ocurre un error de E/S durante el proceso de lectura del archivo.
     */
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
