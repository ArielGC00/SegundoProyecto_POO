
package logicadenegocios;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoMensajeInverso extends Cifrado{
    public CifradoMensajeInverso(){
    
    }
    @Override
    public  String cifrar(String mensaje) {
        char[] caracteres = mensaje.toCharArray();
        StringBuilder mensajeCifrado = new StringBuilder();

        for (int i = caracteres.length - 1; i >= 0; i--) {
            mensajeCifrado.append(caracteres[i]);
        }

        return mensajeCifrado.toString();
    }
    @Override
    public  String descifrar(String mensajeCifrado) {
        return cifrar(mensajeCifrado); // La descifrado es igual al cifrado en este método
    }
}
