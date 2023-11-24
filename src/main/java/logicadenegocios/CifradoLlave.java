
package logicadenegocios;

/**
 *
 * @author Ariel Gomez y Marco perez
 */

public class CifradoLlave {

    private String clave;

    public CifradoLlave() {
    }

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
    
    public void setClave(String nuevaClave) {
        this.clave = nuevaClave.toLowerCase();
    }
}



