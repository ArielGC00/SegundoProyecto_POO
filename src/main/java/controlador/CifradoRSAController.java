
package controlador;
import logicadenegocios.CifradoRSA;
import vistas.Interfaz;
import java.math.BigInteger;
/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoRSAController{
    private final CifradoRSA cifrador;
    private BigInteger n;
    private BigInteger d;
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
            d=cifrador.getD();
            n=cifrador.getN();
            System.out.println("Cifrado--- "+"D:"+d+" N:"+n);
            vista.getSalidaText().setText(mensajeCifrado);
        } else {
            System.out.println("Mensaje original: "+mensajeOriginal);
            System.out.println("D:"+d+" N:"+n);
            String mensajeDecodificado = cifrador.descifrar(mensajeOriginal,d,n);
            vista.getSalidaText().setText(mensajeDecodificado);
        }
    }
}
