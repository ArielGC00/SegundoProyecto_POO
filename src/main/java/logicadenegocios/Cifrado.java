
package logicadenegocios;

/**
 * La clase abstracta <code>Cifrado</code> proporciona una base para la implementación de algoritmos
 * de cifrado y descifrado. Cualquier clase que extienda esta clase abstracta debe proporcionar
 * implementaciones concretas para los métodos {@link #cifrar(String)} y {@link #descifrar(String)}.
 *
 * <p>
 * La clase no implementa directamente ningún algoritmo de cifrado; en cambio, define la interfaz que
 * deben seguir las clases derivadas para proporcionar sus propias implementaciones de cifrado y descifrado.
 * </p>
 *
 * @author Ariel Gomez Y Marco Perez
 * @see CifradoCesar
 * @see CifradoAES
 * @see CifradoBinario
 * @see CifradoInverso
 * @see CifradoLlave
 * @see CifradoMensajeInverso
 * @see CifradoRSA
 * @see CifradoTelefono
 * @see CifradoTripleDES
 * @see CifradoVigenere
 */
public abstract class Cifrado {
     /**
     * Cifra el mensaje proporcionado según el algoritmo de cifrado específico implementado por la clase.
     *
     * @param mensaje El mensaje a cifrar.
     * @return El mensaje cifrado.
     */
    public abstract String cifrar(String mensaje);
    /**
     * Descifra el mensaje proporcionado según el algoritmo de descifrado específico implementado por la clase.
     *
     * @param mensaje El mensaje cifrado a descifrar.
     * @return El mensaje descifrado.
     */
    public abstract String descifrar(String mensaje);
}
 