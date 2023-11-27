
package logicadenegocios;

/**
 * La clase <code>CifradoLlave</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado que utiliza una clave proporcionada por el usuario.
 *
 * @author Ariel Gomez y Marco perez
 * @see logicadenegocios.Cifrado
 */

public class CifradoLlave extends Cifrado{

    private String clave;

    public CifradoLlave() {
    }
    /**
     * Cifra un mensaje utilizando el cifrado por clave.
     *
     * @param mensaje La cadena que se va a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
    
    @Override
    public String cifrar(String palabra) {
        StringBuilder palabraCifrada = new StringBuilder();

        for (int i = 0, j = 0; i < palabra.length(); i++) {
            char letraOriginal = palabra.charAt(i);

            // Si es un espacio en blanco, agregarlo directamente y continuar con la siguiente iteración
            if (letraOriginal == ' ') {
                palabraCifrada.append(' ');
                continue;
            }

            char letraClave = clave.charAt(j);

            int valorOriginal = letraOriginal - 'a' + 1;
            int valorClave = letraClave - 'a' + 1;

            int valorCifrado = (valorOriginal + valorClave - 1) % 26 + 1;

            char letraCifrada = (char) (valorCifrado + 'a' - 1);
            palabraCifrada.append(letraCifrada);

            j = (j + 1) % clave.length();
        }

        return palabraCifrada.toString();
    }
    /**
     * Descifra un mensaje cifrado utilizando el cifrado por clave.
     *
     * @param palabraCifrada La cadena que se va a descifrar.
     * @return Una cadena que representa el mensaje descifrado.
     */
    @Override
    public String descifrar(String palabraCifrada) {
        StringBuilder palabraDescifrada = new StringBuilder();

        for (int i = 0, j = 0; i < palabraCifrada.length(); i++) {
            char letraCifrada = palabraCifrada.charAt(i);

            // Si es un espacio en blanco, agregarlo directamente y continuar con la siguiente iteración
            if (letraCifrada == ' ') {
                palabraDescifrada.append(' ');
                continue;
            }

            char letraClave = clave.charAt(j);

            int valorCifrado = letraCifrada - 'a' + 1;
            int valorClave = letraClave - 'a' + 1;

            int valorDescifrado = (valorCifrado - valorClave - 1 + 26) % 26 + 1;

            char letraDescifrada = (char) (valorDescifrado + 'a' - 1);
            palabraDescifrada.append(letraDescifrada);

            j = (j + 1) % clave.length();
        }

        return palabraDescifrada.toString();
    }
    /**
     * Establece la clave utilizada para el cifrado y descifrado.
     *
     * @param nuevaClave La nueva clave alfabética proporcionada por el usuario.
     */
    public void setClave(String nuevaClave) {
        this.clave = nuevaClave.toLowerCase();
    }
}



