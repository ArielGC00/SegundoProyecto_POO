
package logicadenegocios;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */

import java.math.BigInteger;
import java.security.SecureRandom;
public class CifradoRSA extends Cifrado{
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;
    private BigInteger phiN;
    
    public CifradoRSA(){
    
    }
    
    public void generarClaves() {
        SecureRandom random = new SecureRandom();

        // Paso 1: Generar dos números primos aleatorios p y q
        BigInteger p = BigInteger.probablePrime(512, random);
        BigInteger q = BigInteger.probablePrime(512, random);

        // Paso 2: Calcular n = p * q
        n = p.multiply(q);

        // Paso 3: Calcular φ(n)
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Paso 4: Escoger un número e menor que φ(n)
        do {
            e = new BigInteger(phiN.bitLength(), random);
        } while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phiN) >= 0 || !e.gcd(phiN).equals(BigInteger.ONE)); 
        
    }
    @Override
    public String cifrar(String mensaje) {
        StringBuilder resultado = new StringBuilder();

        for (char caracter : mensaje.toCharArray()) {
            // Aplicar el cifrado a cada carácter
            BigInteger m = BigInteger.valueOf(caracter);
            BigInteger c = m.modPow(e, n);
            resultado.append(c).append("*");
        }

        // Eliminar el último asterisco
        resultado.deleteCharAt(resultado.length() - 1);

        return resultado.toString();
    }
    @Override
    public String descifrar(String mensajeCifrado) {
        // Aquí deberías manejar la situación donde no tienes los parámetros pD y pN
        throw new UnsupportedOperationException("Falta implementar descifrado con clave privada y módulo");
    }

    public String descifrar(String mensajeCifrado, BigInteger pE, BigInteger pN) {
        // Paso 5: Calcular d tal que (d * e) ≡ 1 (mod φ(n))
        d = pE.modInverse(phiN);
        StringBuilder resultado = new StringBuilder();

        // Separar el mensaje cifrado en bloques
        String[] bloques = mensajeCifrado.split("\\*");

        for (String bloque : bloques) {
            // Aplicar el descifrado a cada bloque
            BigInteger c = new BigInteger(bloque);
            BigInteger m = c.modPow(d, pN);
            resultado.append((char) m.intValue());
        }

        return resultado.toString();
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }
}
