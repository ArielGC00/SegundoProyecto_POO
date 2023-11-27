
package logicadenegocios;

/**
 *La clase <code>CifradoRSA</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado utilizando el algoritmo de cifrado RSA (Rivest-Shamir-Adleman).
 *
 * @see logicadenegocios.Cifrado
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
    /**
     * Genera las claves necesarias para el cifrado y descifrado RSA.
     */
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
    /**
     * Cifra un mensaje utilizando el algoritmo de cifrado RSA.
     *
     * @param mensaje La cadena que se va a cifrar.
     * @return Una cadena que representa el mensaje cifrado.
     */
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
    /**
     * Descifra un mensaje cifrado utilizando el algoritmo de descifrado RSA.
     *
     * @param mensajeCifrado La cadena que se va a descifrar.
     * @return Una cadena que representa el mensaje descifrado.
     */
    @Override
    public String descifrar(String mensajeCifrado) {
        // Aquí deberías manejar la situación donde no tienes los parámetros pD y pN
        throw new UnsupportedOperationException("Falta implementar descifrado con clave privada y módulo");
    }
    /**
     * Descifra un mensaje cifrado utilizando una clave privada y un módulo dados.
     *
     * @param mensajeCifrado La cadena que se va a descifrar.
     * @param pE             La clave privada.
     * @param pN             El módulo.
     * @return Una cadena que representa el mensaje descifrado.
     */
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
    /**
     * Obtiene el módulo utilizado en el cifrado y descifrado RSA.
     *
     * @return El módulo.
     */
    public BigInteger getN() {
        return n;
    }
    /**
     * Obtiene la clave pública utilizada en el cifrado RSA.
     *
     * @return La clave pública.
     */
    public BigInteger getE() {
        return e;
    }
}
