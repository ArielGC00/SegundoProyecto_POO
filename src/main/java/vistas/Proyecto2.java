
package vistas;



import controlador.CifradoBinarioController;
import controlador.CifradoCesarController;
import controlador.CifradoInversoController;
import controlador.CifradoLlaveController;
import controlador.CifradoMensajeInversoController;
import controlador.CifradoRSAController;
import controlador.CifradoTelefonoController;
import controlador.CifradoVigenereController;
import java.awt.event.ActionEvent;
import logicadenegocios.CifradoRSA;
import java.math.BigInteger;

/**
 *
 * @author marcoperez
 */
public class Proyecto2 {

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);

        // Crear instancia del controlador
        CifradoBinarioController CifradoBinarioController = new CifradoBinarioController(interfaz);
        CifradoRSAController CifradoRSAController= new CifradoRSAController(interfaz);
        CifradoCesarController CifradoCesarController=new CifradoCesarController(interfaz);
        CifradoInversoController CifradoInversoController=new CifradoInversoController(interfaz);
        CifradoLlaveController CifradoLlaveController=new CifradoLlaveController(interfaz);
        CifradoMensajeInversoController CifradoMensajeInversoController=new CifradoMensajeInversoController(interfaz);
        CifradoTelefonoController CifradoTelefonoController=new CifradoTelefonoController(interfaz);
        CifradoVigenereController CifradoVigenereController=new CifradoVigenereController(interfaz);
        
        
        // Manejar la lógica de cifrado/descifrado al hacer clic en el botón
        interfaz.getBotonAplicarAlgoritmo().addActionListener((ActionEvent evt) -> {
            String tipoCifrado=(String) interfaz.getOpcionTipoCifrado().getSelectedItem();
            switch (tipoCifrado){
                case "Binario":
                    System.out.println("Opción 1 seleccionada");
                    CifradoBinarioController.aplicarAlgoritmo();
                    break;
                case "RSA":
                    CifradoRSAController.aplicarAlgoritmo();
                    break;
                case "César":
                    CifradoCesarController.aplicarAlgoritmo();
                    break;
                case "inverso":
                    CifradoInversoController.aplicarAlgoritmo();
                    break;
                case "Llave":
                    CifradoLlaveController.aplicarAlgoritmo();
                    break;
                case "Mensaje":
                    CifradoMensajeInversoController.aplicarAlgoritmo();
                    break;
                case "Código telefónico":
                    CifradoTelefonoController.aplicarAlgoritmo();
                    break;
                case "Vigenére":
                    CifradoVigenereController.aplicarAlgoritmo();
                default:
                     System.out.println("Opción no reconocida");
            }
            
        });
    });

    }
}

