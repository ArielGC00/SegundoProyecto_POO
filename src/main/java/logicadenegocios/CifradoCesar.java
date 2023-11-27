
package logicadenegocios;

/**
 *
 * La clase <code>CifradoCesar</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado utilizando el cifrado César.
 * <p>
 * El cifrado César es un método de cifrado por sustitución simple en el que cada letra en el texto sin formato
 * se desplaza un número fijo de posiciones hacia la derecha en el alfabeto. En esta implementación, el desplazamiento
 * (clave) predeterminado es de 3 posiciones, pero puede ser modificado según sea necesario.
 * </p>
 *
 * @author Ariel Gomez y Marco Perez
 * 
 * @see logicadenegocios.Cifrado
 */


public class CifradoCesar extends Cifrado{
    private int clave = 3;
    
    public CifradoCesar() {
    }
    /**
     * Cifra el mensaje utilizando el cifrado César.
     *
     * @param mensaje El mensaje a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
    @Override
    public String cifrar(String mensaje) {
        StringBuilder mensajeCifrado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char caracterOriginal = mensaje.charAt(i);

            // Verificar si el carácter es una letra
            if (Character.isLetter(caracterOriginal)) {
                // Obtener el rango base dependiendo de si es mayúscula o minúscula
                char rangoBase = Character.isUpperCase(caracterOriginal) ? 'A' : 'a';

                char caracterCifrado = (char) (((caracterOriginal - rangoBase + clave + 26) % 26) + rangoBase);

                mensajeCifrado.append(caracterCifrado);
            } else {
                // Si no es una letra, mantener el carácter sin cambios
                mensajeCifrado.append(caracterOriginal);
            }
        }

        return mensajeCifrado.toString();
    }
    /**
     * Descifra el mensaje cifrado utilizando el cifrado César.
     *
     * @param mensajeCifrado Una cadena que contiene el mensaje cifrado.
     * @return El mensaje descifrado.
     */
    @Override
    public String descifrar(String mensajeCifrado) {
        StringBuilder mensajeDescifrado = new StringBuilder();

        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char caracterCifrado = mensajeCifrado.charAt(i);

            // Verificar si el carácter es una letra
            if (Character.isLetter(caracterCifrado)) {
                // Obtener el rango base dependiendo de si es mayúscula o minúscula
                char rangoBase = Character.isUpperCase(caracterCifrado) ? 'A' : 'a';

                char caracterDescifrado = (char) (((caracterCifrado - rangoBase - clave + 26) % 26) + rangoBase);

                mensajeDescifrado.append(caracterDescifrado);
            } else {
                // Si no es una letra, mantener el carácter sin cambios
                mensajeDescifrado.append(caracterCifrado);
            }
        }

        return mensajeDescifrado.toString();
    }
}