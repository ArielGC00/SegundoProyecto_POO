
package vistas;



import controlador.CifradoAESController;
import controlador.CifradoBinarioController;
import controlador.CifradoCesarController;
import controlador.CifradoInversoController;
import controlador.CifradoLlaveController;
import controlador.CifradoMensajeInversoController;
import controlador.CifradoRSAController;
import controlador.CifradoTelefonoController;
import controlador.CifradoTripleDESController;
import controlador.CifradoVigenereController;
import java.awt.event.ActionEvent;

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
        CifradoTripleDESController CifradoTripleDESController=new CifradoTripleDESController(interfaz);
        CifradoAESController CifradoAESController =new CifradoAESController(interfaz);
        
        
        // Manejar la lógica de cifrado/descifrado al hacer clic en el botón
        interfaz.getBotonAplicarAlgoritmo().addActionListener((ActionEvent evt) -> {
            String tipoCifrado=(String) interfaz.getOpcionTipoCifrado().getSelectedItem();
            switch (tipoCifrado){
                case "Binario":
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
                    break;
                case "DES":
                    CifradoTripleDESController.aplicarAlgoritmo();
                    break;
                case "AE":
                    CifradoAESController.aplicarAlgoritmo();
                    break;
                default:
                     System.out.println("Opción no reconocida");
            }
            
        });
    });

    }
}

