
package logicadenegocios;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ariel Gmez y Marco Perez
 */

public class CifradoVigenere extends Cifrado{
    private int clave;

    public void setClave(int clave) {
        this.clave = clave;
    }

    private final Map<Character, Integer> tablaVigenere;

    public CifradoVigenere() {
        tablaVigenere = new HashMap<>();
        inicializarTabla();
    }

    private void inicializarTabla() {
        char letra = 'a';
        for (int i = 1; i <= 26; i++) {
            tablaVigenere.put(letra, i);
            letra++;
        }
    }
    
    @Override
    public String cifrar(String mensaje) {
        StringBuilder mensajeCifrado = new StringBuilder();
        String[] palabras = mensaje.toLowerCase().split(" ");
        int contador = 0; // Para manejar la posición en la clave

        for (String palabra : palabras) {
            for (char caracter : palabra.toCharArray()) {
                if (Character.isLetter(caracter)) {
                    int valorCaracter = tablaVigenere.get(caracter);
                    int valorCifrado = (valorCaracter + clave) % 26;
                    mensajeCifrado.append(valorCifrado).append(" ");
                    contador = (contador + 1) % String.valueOf(clave).length();
                }
            }
        }

        return mensajeCifrado.toString().trim();
    }
    
    @Override
    public String descifrar(String mensaje) {
        StringBuilder mensajeDescifrado = new StringBuilder();
        String[] palabras = mensaje.split(" ");
        int contador = 0; // Para manejar la posición en la clave

        for (String palabra : palabras) {
            int valorCifrado = Integer.parseInt(palabra);
            int valorDescifrado = (valorCifrado - clave + 26) % 26;
            char caracterDescifrado = obtenerCaracterPorValor(valorDescifrado);
            mensajeDescifrado.append(caracterDescifrado);
            contador = (contador + 1) % String.valueOf(clave).length();
        }

        return mensajeDescifrado.toString();
    }

    private char obtenerCaracterPorValor(int valor) {
        for (Map.Entry<Character, Integer> entry : tablaVigenere.entrySet()) {
            if (entry.getValue() == valor) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
