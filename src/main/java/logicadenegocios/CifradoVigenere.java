
package logicadenegocios;


/**
 *
 * @author Ariel Gmez y Marco Perez
 */

public class CifradoVigenere extends Cifrado {
    private String clave;

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


