
package logicadenegocios;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoInverso extends Cifrado{
    
    public CifradoInverso() {
    }
    @Override
    public String cifrar(String mensaje) {
        String[] palabras = mensaje.split("\\s+");
        StringBuilder mensajeCifrado = new StringBuilder();

        for (String palabra : palabras) {
            mensajeCifrado.append(invertirPalabra(palabra)).append(" ");
        }

        return mensajeCifrado.toString().trim();
    }

    private String invertirPalabra(String palabra) {
        char[] caracteres = palabra.toCharArray();
        StringBuilder palabraInvertida = new StringBuilder();

        for (int i = caracteres.length - 1; i >= 0; i--) {
            palabraInvertida.append(caracteres[i]);
        }

        return palabraInvertida.toString();
    }
    @Override
    public String descifrar(String mensajeCifrado) {
        return cifrar(mensajeCifrado);
    }
}
