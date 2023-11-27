
package logicadenegocios;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

/**
 *La clase <code>CifradoAES</code> extiende la clase abstracta {@link logicadenegocios.Cifrado} e implementa
 * un algoritmo de cifrado y descifrado utilizando el estándar AES (Advanced Encryption Standard).
 *
 * <p>
 * Utiliza una clave secreta generada de forma aleatoria y un vector de inicialización (IV) también generado
 * de forma aleatoria para cifrar y descifrar el mensaje. El algoritmo de cifrado utiliza el modo de operación
 * CBC (Cipher Block Chaining) con el esquema de relleno PKCS5Padding.
 * </p>
 *
 * @author Ariel Gomez y Marco Perez
  * @see logicadenegocios.Cifrado
 * @see javax.crypto.Cipher
 * @see javax.crypto.KeyGenerator
 * @see javax.crypto.SecretKey
 * @see javax.crypto.spec.IvParameterSpec
 * @see java.util.Base64
 * @see javax.crypto.spec.SecretKeySpec
 */
public class CifradoAES extends Cifrado {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    
    /**
     * Cifra el mensaje utilizando el algoritmo AES con una clave generada aleatoriamente y un IV aleatorio.
     *
     * @param mensaje El mensaje a cifrar.
     * @return Una cadena que representa la clave cifrada, el IV cifrado y el mensaje cifrado, separados por ":".
     *         Retorna {@code null} en caso de errores.
     */

    @Override
    public String cifrar(String mensaje) {
        try {
            // Generar una clave secreta
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(256); // Tamaño de clave de 256 bits para AES
            SecretKey secretKey = keyGenerator.generateKey();

            // Generar un vector de inicialización aleatorio
            byte[] iv = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Inicializar el cifrador
            Cipher cifrador = Cipher.getInstance(TRANSFORMATION);
            cifrador.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            // Cifrar el mensaje
            byte[] mensajeCifrado = cifrador.doFinal(mensaje.getBytes("UTF-8"));

            // Convertir la clave y el IV a base64 para obtener una representación de cadena segura
            String claveCifrada = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            String ivCifrado = Base64.getEncoder().encodeToString(iv);

            // Devolver el resultado concatenando clave, IV y mensaje cifrado
            return claveCifrada + ":" + ivCifrado + ":" + Base64.getEncoder().encodeToString(mensajeCifrado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Descifra el mensaje cifrado utilizando el algoritmo AES con la clave y el IV proporcionados.
     *
     * @param mensajeCifrado Una cadena que contiene la clave cifrada, el IV cifrado y el mensaje cifrado,
     *                        separados por ":".
     * @return El mensaje descifrado. Retorna {@code null} en caso de errores.
     */
    @Override
    public String descifrar(String mensajeCifrado) {
        try {
            // Separar la clave, el IV y el mensaje cifrado
            String[] partes = mensajeCifrado.split(":");
            String claveCifrada = partes[0];
            String ivCifrado = partes[1];
            String mensajeCifradoBase64 = partes[2];

            // Decodificar la clave y el IV desde base64
            byte[] claveBytes = Base64.getDecoder().decode(claveCifrada);
            byte[] ivBytes = Base64.getDecoder().decode(ivCifrado);

            // Crear objetos SecretKey e IvParameterSpec
            SecretKey secretKey = new SecretKeySpec(claveBytes, ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            // Inicializar el cifrador para descifrar
            Cipher cifrador = Cipher.getInstance(TRANSFORMATION);
            cifrador.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            // Descifrar el mensaje
            byte[] mensajeDescifrado = cifrador.doFinal(Base64.getDecoder().decode(mensajeCifradoBase64));

            return new String(mensajeDescifrado, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
