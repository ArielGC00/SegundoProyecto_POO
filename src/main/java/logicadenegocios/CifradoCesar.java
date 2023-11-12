
package logicadenegocios;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */


public class CifradoCesar {
    private int clave = 3;

    public CifradoCesar() {
    }

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

