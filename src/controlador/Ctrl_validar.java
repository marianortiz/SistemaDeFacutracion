
package controlador;

import java.util.ArrayList;
import sistfacturacion.Factura;


public class Ctrl_validar {
    
   
    
    public Ctrl_validar() {
    }
    
    public static boolean validaDato(String a){
        try{
           Double.parseDouble(a);
           return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
}

