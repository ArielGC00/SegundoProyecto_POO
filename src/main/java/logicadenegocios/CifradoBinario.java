
package logicadenegocios;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * La clase <code>CifradoBinario</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado utilizando el cifrado binario de Bacon.
 *
 * <p>
 * El cifrado binario de Bacon es un método de codificación de mensajes que representa cada letra del alfabeto
 * con una cadena binaria de 5 bits. En este cifrado, las letras se dividen en dos grupos (A y B), y cada letra
 * es representada por una combinación de ceros (0) y unos (1) según su grupo.
 * </p>
 * @author Ariel Gomez y Marco Perez
 * @see logicadenegocios.Cifrado
 */

public class CifradoBinario extends Cifrado{
  
  private static final Map<Character, String> alfabetoBacon = new HashMap<>();
  static {
    alfabetoBacon.put('a', "00000");
    alfabetoBacon.put('b', "00001");
    alfabetoBacon.put('c', "00010");
    alfabetoBacon.put('d', "00011");
    alfabetoBacon.put('e', "00100");
    alfabetoBacon.put('f', "00101");
    alfabetoBacon.put('g', "00110");
    alfabetoBacon.put('h', "00111");
    alfabetoBacon.put('i', "01000");
    alfabetoBacon.put('j', "01001");
    alfabetoBacon.put('k', "01010");
    alfabetoBacon.put('l', "01011");
    alfabetoBacon.put('m', "01100");
    alfabetoBacon.put('n', "01101");
    alfabetoBacon.put('o', "01110");
    alfabetoBacon.put('p', "01111");
    alfabetoBacon.put('q', "10000");
    alfabetoBacon.put('r', "10001");
    alfabetoBacon.put('s', "10010");
    alfabetoBacon.put('t', "10011");
    alfabetoBacon.put('u', "10100");
    alfabetoBacon.put('v', "10101");
    alfabetoBacon.put('w', "10110");
    alfabetoBacon.put('x', "10111");
    alfabetoBacon.put('y', "11000");
    alfabetoBacon.put('z', "11001");
    }
    /**
     * Cifra el mensaje utilizando el cifrado binario de Bacon.
     *
     * @param mensaje El mensaje a cifrar.
     * @return Una cadena que representa el mensaje cifrado. Retorna una cadena vacía en caso de no encontrar
     *         una representación binaria para una letra.
     */
    @Override
    public String cifrar(String mensaje) {
        StringBuilder mensajeCifrado = new StringBuilder();

        for (char caracter : mensaje.toLowerCase().toCharArray()) {
            if (alfabetoBacon.containsKey(caracter)) {
                mensajeCifrado.append(alfabetoBacon.get(caracter)).append(" ");
            } else if (caracter == ' ') {
                mensajeCifrado.append("* ");
            }
        }

        return mensajeCifrado.toString().trim();
    }
    /**
     * Descifra el mensaje cifrado utilizando el cifrado binario de Bacon.
     *
     * @param mensajeCifrado Una cadena que contiene el mensaje cifrado.
     * @return El mensaje descifrado. Retorna una cadena vacía en caso de no encontrar una letra
     *         correspondiente para un conjunto de bits.
     */
    @Override
    public String descifrar(String mensajeCifrado) {
        StringBuilder mensajeDescifrado = new StringBuilder();
        String[] bloques = mensajeCifrado.split(" ");

        for (String bloque : bloques) {
            if (bloque.equals("*")) {
                mensajeDescifrado.append(" ");
            } else {
                char caracterDescifrado = obtenerCaracterPorCodigo(bloque);
                mensajeDescifrado.append(caracterDescifrado);
            }
        }

        return mensajeDescifrado.toString();
    }
    /**
     * Obtiene el caracter correspondiente a un código binario de Bacon.
     *
     * @param codigo El código binario de Bacon.
     * @return El caracter correspondiente al código. Retorna un espacio en blanco si no se encuentra
     *         una correspondencia.
     */
    private static char obtenerCaracterPorCodigo(String codigo) {
        for (Map.Entry<Character, String> entry : alfabetoBacon.entrySet()) {
            if (entry.getValue().equals(codigo)) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}

