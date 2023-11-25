
package logicadenegocios;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.util.Base64;

/**
 *
 * @author Ariel Gomez y Marco Perez
 */
public class CifradoTripleDES extends Cifrado {
    private static final String ALGORITHM = "DESede";
    private static final String KEY_STRING = "una_clave_secreta_de_24_bytes";

    @Override
    public String cifrar(String mensaje) {
        try {
            // Generar una clave secreta
            byte[] keyBytes = KEY_STRING.getBytes("UTF-8");
            DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey key = keyFactory.generateSecret(keySpec);

            // Inicializar el cifrador
            Cipher cifrador = Cipher.getInstance(ALGORITHM);
            cifrador.init(Cipher.ENCRYPT_MODE, key);

            // Cifrar el mensaje
            byte[] mensajeCifrado = cifrador.doFinal(mensaje.getBytes("UTF-8"));

            // Convertir a base64 para obtener una representación de cadena segura
            return Base64.getEncoder().encodeToString(mensajeCifrado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String descifrar(String mensajeCifrado) {
        try {
            // Generar una clave secreta
            byte[] keyBytes = KEY_STRING.getBytes("UTF-8");
            DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey key = keyFactory.generateSecret(keySpec);

            // Inicializar el cifrador para descifrar
            Cipher cifrador = Cipher.getInstance(ALGORITHM);
            cifrador.init(Cipher.DECRYPT_MODE, key);

            // Descifrar el mensaje
            byte[] mensajeDescifrado = cifrador.doFinal(Base64.getDecoder().decode(mensajeCifrado));

            return new String(mensajeDescifrado, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

