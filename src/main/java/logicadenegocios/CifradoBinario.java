/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */

public class CifradoBinario {
  
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

    public static String cifrar(String mensaje) {
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

    public static String descifrar(String mensajeCifrado) {
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

    private static char obtenerCaracterPorCodigo(String codigo) {
        for (Map.Entry<Character, String> entry : alfabetoBacon.entrySet()) {
            if (entry.getValue().equals(codigo)) {
                return entry.getKey();
            }
        }
        return ' ';
    }


}

  
  

