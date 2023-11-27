
package controlador;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import logicadenegocios.CifradoRSA;
import vistas.Interfaz;
import java.math.BigInteger;
import javax.swing.JOptionPane;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoRSAController{
    private final CifradoRSA cifrador;
    private BigInteger n;
    private BigInteger e;
    private Interfaz vista;

    public CifradoRSAController(Interfaz vista) {
        this.cifrador = new CifradoRSA();
        this.cifrador.generarClaves();
        this.vista=vista;
    }

    
    
    public void aplicarAlgoritmo() {
        String mensajeOriginal = vista.getEntradaText().getText();
        String accion = (String) vista.getAccionCodDec().getSelectedItem();

        if (accion.equals("Codificar")) {
            String mensajeCifrado = cifrador.cifrar(mensajeOriginal);
            e=cifrador.getE();
            n=cifrador.getN();
            System.out.println("Cifrado--- "+"D:"+e+" N:"+n);
            mostrarMensajeConCopiaAlPortapapeles(vista, "Clave 1: " + n);
            mostrarMensajeConCopiaAlPortapapeles(vista, "Clave 2: " + e);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            try {
            // Si el tipo de cifrado es "Llave", obtener la clave del usuario
            String strClaveN = JOptionPane.showInputDialog(vista, "Ingrese la clave 1 para descifrar");
            String strClaveE = JOptionPane.showInputDialog(vista, "Ingrese la clave 2 para descifrar");

            // Convertir las cadenas a BigInteger
            BigInteger claveN = new BigInteger(strClaveN);
            BigInteger claveE = new BigInteger(strClaveE);

            System.out.println("Mensaje original: " + mensajeOriginal);
            System.out.println("E:" + e + " N:" + n);

            String mensajeDecodificado = cifrador.descifrar(mensajeOriginal, claveE, claveN);
            vista.getSalidaText().setText(mensajeDecodificado);
            } catch (NumberFormatException e) {
                // Capturar la excepción si la entrada del usuario no es un número válido
                JOptionPane.showMessageDialog(vista, "Error: Ingrese números válidos para las claves.");
                vista.getSalidaText().setText(" ");
            }
        }
    }
    private void mostrarMensajeConCopiaAlPortapapeles(Interfaz vista, String mensaje) {
        // Copiar al portapapeles
        StringSelection stringSelection = new StringSelection(mensaje);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // Mostrar el cuadro de diálogo con la opción de copiar al portapapeles
        JOptionPane.showMessageDialog(vista, mensaje, "Clave", JOptionPane.INFORMATION_MESSAGE);
    }

        
}
