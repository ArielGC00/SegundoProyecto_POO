
package logicadenegocios;

/**
* La clase <code>CifradoInverso</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado que consiste en invertir el orden de las palabras en un mensaje.
 *
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoInverso extends Cifrado{
    
    public CifradoInverso() {
    }
     /**
     * Cifra el mensaje invirtiendo el orden de las letras en cada palabra.
     *
     * @param mensaje El mensaje a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
    @Override
    public String cifrar(String mensaje) {
        String[] palabras = mensaje.split("\\s+");
        StringBuilder mensajeCifrado = new StringBuilder();

        for (String palabra : palabras) {
            mensajeCifrado.append(invertirPalabra(palabra)).append(" ");
        }

        return mensajeCifrado.toString().trim();
    }
     /**
     * Invierte el orden de las letras en una palabra.
     *
     * @param palabra La palabra a invertir.
     * @return La palabra con el orden de las letras invertido.
     */
    private String invertirPalabra(String palabra) {
        char[] caracteres = palabra.toCharArray();
        StringBuilder palabraInvertida = new StringBuilder();

        for (int i = caracteres.length - 1; i >= 0; i--) {
            palabraInvertida.append(caracteres[i]);
        }

        return palabraInvertida.toString();
    }
    /**
     * Descifra el mensaje cifrado, que en este caso es equivalente a cifrar nuevamente.
     *
     * @param mensajeCifrado Una cadena que contiene el mensaje cifrado.
     * @return El mensaje descifrado, que es equivalente a cifrar nuevamente.
     */
    @Override
    public String descifrar(String mensajeCifrado) {
        return cifrar(mensajeCifrado);
    }
}
