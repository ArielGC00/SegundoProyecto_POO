
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
import logicadenegocios.ValidacionAscii;
import logicadenegocios.ValidacionTecladoTelefonico;

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
        ValidacionTecladoTelefonico validacionTeclado = new ValidacionTecladoTelefonico();
        ValidacionAscii ValidacionAscii=new ValidacionAscii();
        
        
        
        // Manejar la lógica de cifrado/descifrado al hacer clic en el botón
        interfaz.getBotonAplicarAlgoritmo().addActionListener((ActionEvent evt) -> {
            String tipoCifrado=(String) interfaz.getOpcionTipoCifrado().getSelectedItem();
            String mensajeOriginal = interfaz.getEntradaText().getText();
            String cifrarDescifrar=(String) interfaz.getAccionCodDec().getSelectedItem();
            // Crear instancia de ValidacionTecladoTelefonico
            

            switch (tipoCifrado){
                case "Binario":
                    
                    CifradoBinarioController.aplicarAlgoritmo();
                    break;
                case "RSA":
                    if(ValidacionAscii.validar(mensajeOriginal, interfaz)==true){
                        if(cifrarDescifrar.equals("Codificar")){
                            if(ValidacionAscii.validarEspecificoCifrado(mensajeOriginal, interfaz)==true){
                                CifradoRSAController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }else{
                            if(ValidacionAscii.validarEspecificoDescifrado(mensajeOriginal, interfaz)==true){
                                CifradoRSAController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
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
                    if(validacionTeclado.validar(mensajeOriginal, interfaz)==true){
                        if(cifrarDescifrar.equals("Codificar")){
                            if(validacionTeclado.validarEspecificoCifrado(mensajeOriginal, interfaz)==true){
                                CifradoTelefonoController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }else{
                            if(validacionTeclado.validarEspecificoDescifrado(mensajeOriginal, interfaz)==true){
                                CifradoTelefonoController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                    
                case "Vigenére":
                    CifradoVigenereController.aplicarAlgoritmo();
                    break;
                case "DES":
                    if(ValidacionAscii.validar(mensajeOriginal, interfaz)==true){
                        if(cifrarDescifrar.equals("Codificar")){
                            if(ValidacionAscii.validarEspecificoCifrado(mensajeOriginal, interfaz)==true){
                                CifradoTripleDESController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }else{
                            if(ValidacionAscii.validarEspecificoDescifrado(mensajeOriginal, interfaz)==true){
                                CifradoTripleDESController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                case "AE":
                    if(ValidacionAscii.validar(mensajeOriginal, interfaz)==true){
                        if(cifrarDescifrar.equals("Codificar")){
                            if(ValidacionAscii.validarEspecificoCifrado(mensajeOriginal, interfaz)==true){
                                CifradoAESController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }else{
                            if(ValidacionAscii.validarEspecificoDescifrado(mensajeOriginal, interfaz)==true){
                                CifradoAESController.aplicarAlgoritmo();
                                break;
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                default:
                     System.out.println("Opción no reconocida");
            }
            
        });
    });

    }
}

