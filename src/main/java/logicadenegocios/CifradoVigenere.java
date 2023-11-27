
package logicadenegocios;


/**
 *
 * La clase <code>CifradoVigenere</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado utilizando el cifrado Vigenère.
 *
 * @see logicadenegocios.Cifrado
 * 
 * @author Ariel Gmez y Marco Perez
 */

public class CifradoVigenere extends Cifrado {
    private String clave;
    
    /**
     * Establece la clave numérica utilizada en el cifrado Vigenère.
     *
     * @param clave La clave numérica como una cadena.
     */
    public void setClave(String clave) {
        try {
            int claveComoInt = Integer.parseInt(clave);
            int claveModificada=claveComoInt+11;
            String numeroComoString = String.valueOf(claveModificada);
            this.clave = numeroComoString.toUpperCase();
            
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el String a int: " + e.getMessage());
        }
         // Convertir la clave a mayúsculas para facilitar la manipulación
    }
    /**
     * Cifra un mensaje utilizando el cifrado Vigenère.
     *
     * @param mensaje La cadena que se va a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
    @Override
    public String cifrar(String mensaje) {
        StringBuilder mensajeCifrado = new StringBuilder();

        int claveIndex = 0;
        for (char caracter : mensaje.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                int offset = clave.charAt(claveIndex) - '1';
                char cifrado = (char) ((caracter - base + offset) % 26 + base);
                mensajeCifrado.append(cifrado);

                // Avanzar al siguiente carácter de la clave (cíclicamente)
                claveIndex = (claveIndex + 1) % clave.length();
            } else {
                // Mantener caracteres no alfabéticos sin cambios
                mensajeCifrado.append(caracter);

                // Restablecer el índice de clave cuando hay un espacio
                if (caracter == ' ') {
                    claveIndex = 0;
                }
            }
        }

        return mensajeCifrado.toString();
    }
    /**
     * Descifra un mensaje cifrado utilizando el cifrado Vigenère.
     *
     * @param mensaje La cadena cifrada.
     * @return Una cadena que representa el mensaje descifrado.
     */
    @Override
    public String descifrar(String mensaje) {
        StringBuilder mensajeDescifrado = new StringBuilder();

        int claveIndex = 0;
        for (char caracter : mensaje.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                int offset = clave.charAt(claveIndex) - '1';
                // Fórmula de descifrado: (caracter - base - offset + 26) % 26 + base
                char descifrado = (char) ((caracter - base - offset + 26) % 26 + base);
                mensajeDescifrado.append(descifrado);

                // Avanzar al siguiente carácter de la clave (cíclicamente)
                claveIndex = (claveIndex + 1) % clave.length();
            } else {
                // Mantener caracteres no alfabéticos sin cambios
                mensajeDescifrado.append(caracter);
                // Restablecer el índice de clave cuando hay un espacio
                if (caracter == ' ') {
                    claveIndex = 0;
                }
            }
        }

        return mensajeDescifrado.toString();
    }
}


