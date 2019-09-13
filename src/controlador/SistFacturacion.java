/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import sistfacturacion.Factura;
import vista.Jframe_Factura;

public class SistFacturacion {

   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        ArrayList<Factura> facturas = new ArrayList();
        
        Jframe_Factura jf_factura = new Jframe_Factura();
        
        Ctrl_Factura ctrl_fac = new Ctrl_Factura(facturas, jf_factura);

        
        
    }
    
}
