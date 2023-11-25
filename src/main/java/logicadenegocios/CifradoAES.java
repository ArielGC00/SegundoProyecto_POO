
package logicadenegocios;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoAES extends Cifrado {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

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
