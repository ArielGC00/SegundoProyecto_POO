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
public class CifradoTelefono extends Cifrado{
    private static final Map<Character, String> teclado = new HashMap<>();

    static {
        teclado.put('a', "21");
        teclado.put('b', "22");
        teclado.put('c', "23");
        teclado.put('d', "31");
        teclado.put('e', "32");
        teclado.put('f', "33");
        teclado.put('g', "41");
        teclado.put('h', "42");
        teclado.put('i', "43");
        teclado.put('j', "51");
        teclado.put('k', "52");
        teclado.put('l', "53");
        teclado.put('m', "61");
        teclado.put('n', "62");
        teclado.put('o', "63");
        teclado.put('p', "71");
        teclado.put('q', "72");
        teclado.put('r', "73");
        teclado.put('s', "74");
        teclado.put('t', "81");
        teclado.put('u', "82");
        teclado.put('v', "83");
        teclado.put('w', "91");
        teclado.put('x', "92");
        teclado.put('y', "93");
        teclado.put('z', "94");
    }
    @Override
    public String cifrar(String mensaje) {
        StringBuilder resultado = new StringBuilder();

        for (char letra : mensaje.toLowerCase().toCharArray()) {
            if (letra == ' ') {
                resultado.append("* ");
            } else if (teclado.containsKey(letra)) {
                resultado.append(teclado.get(letra)).append(" ");
            }
        }

        return resultado.toString().trim();
    }
    @Override
    public String descifrar(String mensajeCifrado) {
        StringBuilder resultado = new StringBuilder();
        String[] partes = mensajeCifrado.split(" ");

        for (String parte : partes) {
            if (parte.equals("*")) {
                resultado.append(" ");
            } else {
                for (Map.Entry<Character, String> entry : teclado.entrySet()) {
                    if (entry.getValue().equals(parte)) {
                        resultado.append(entry.getKey());
                        break;
                    }
                }
            }
        }

        return resultado.toString();
    }
}
