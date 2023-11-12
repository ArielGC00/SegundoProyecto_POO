
/**
 *
 * @author Ariel Gomez y Marco perez
 */
package controlador;

import vistas.Interfaz;

public abstract class CifradoController {

    protected Interfaz vista;

    public CifradoController(Interfaz vista) {
        this.vista = vista;
        configurarListeners();
    }

    protected abstract void configurarListeners();

    public abstract void aplicarAlgoritmo();
}

