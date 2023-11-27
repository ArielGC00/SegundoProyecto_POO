
package controlador;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import logicadenegocios.CifradoRSA;
import vistas.Interfaz;
import java.math.BigInteger;
import javax.swing.JOptionPane;
/**
 ** La clase <code>CifradoRSAController</code> es un controlador que gestiona la aplicación
 * del algoritmo de cifrado RSA en una interfaz gráfica. Está asociada con la clase
 * {@link vistas.Interfaz} y utiliza la lógica de negocios proporcionada por la clase
 * {@link logicadenegocios.CifradoRSA}.
 * 
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoRSAController{
    private final CifradoRSA cifrador;
    private BigInteger n;
    private BigInteger e;
    private Interfaz vista;
    /**
     * Construye un <code>CifradoRSAController</code> con la instancia de la interfaz
     * proporcionada. Utiliza una instancia de {@link logicadenegocios.CifradoRSA} para realizar
     * operaciones de cifrado y descifrado utilizando el algoritmo de cifrado RSA.
     * Genera automáticamente las claves pública y privada al momento de la creación del controlador.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     */
    public CifradoRSAController(Interfaz vista) {
        this.cifrador = new CifradoRSA();
        this.cifrador.generarClaves();
        this.vista=vista;
    }

    
    /**
     * Aplica el algoritmo de cifrado RSA al mensaje proporcionado en la interfaz gráfica.
     * El tipo de acción (codificar o descifrar) se determina a través del elemento seleccionado
     * en el combo box de la interfaz.
     * Si la acción es "Codificar", muestra las claves generadas y copia cada una al portapapeles.
     * Si la acción es "Descifrar", solicita al usuario ingresar las claves necesarias y muestra
     * el mensaje descifrado en el área de salida.
     */
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
    /**
     * Muestra un mensaje en la interfaz gráfica y copia el mensaje al portapapeles.
     *
     * @param vista La interfaz gráfica asociada con este controlador.
     * @param mensaje El mensaje a mostrar y copiar al portapapeles.
     */
    private void mostrarMensajeConCopiaAlPortapapeles(Interfaz vista, String mensaje) {
        // Copiar al portapapeles
        StringSelection stringSelection = new StringSelection(mensaje);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // Mostrar el cuadro de diálogo con la opción de copiar al portapapeles
        JOptionPane.showMessageDialog(vista, mensaje, "Clave", JOptionPane.INFORMATION_MESSAGE);
    }

        
}
