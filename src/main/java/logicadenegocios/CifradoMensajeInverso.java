
package logicadenegocios;

/**
 * La clase <code>CifradoMensajeInverso</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado que invierte el orden de los caracteres en un mensaje.
 *
 * @see logicadenegocios.Cifrado
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoMensajeInverso extends Cifrado{
    public CifradoMensajeInverso(){
    
    }
    /**
     * Cifra un mensaje invirtiendo el orden de sus caracteres.
     *
     * @param mensaje La cadena que se va a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
    @Override
    public  String cifrar(String mensaje) {
        char[] caracteres = mensaje.toCharArray();
        StringBuilder mensajeCifrado = new StringBuilder();

        for (int i = caracteres.length - 1; i >= 0; i--) {
            mensajeCifrado.append(caracteres[i]);
        }

        return mensajeCifrado.toString();
    }
    /**
     * Descifra un mensaje cifrado invirtiendo el orden de sus caracteres.
     *
     * @param mensajeCifrado La cadena que se va a descifrar.
     * @return Una cadena que representa el mensaje descifrado.
     */
    @Override
    public  String descifrar(String mensajeCifrado) {
        return cifrar(mensajeCifrado); // La descifrado es igual al cifrado en este método
    }
}
