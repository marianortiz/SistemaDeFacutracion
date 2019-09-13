
package controlador;

import datos.FacturaDAO;
import sistfacturacion.Factura;
import vista.Jframe_Factura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Ctrl_Factura implements ActionListener {
    
    Jframe_Factura jf_fac1;
    ArrayList<Factura> fac1 = new ArrayList<>();
    private FacturaDAO fDAO = new FacturaDAO();
    

    public Ctrl_Factura(ArrayList<Factura> fac1, Jframe_Factura jf_fac1) {
        this.fac1 = fac1;
        this.jf_fac1 = jf_fac1;
        
        jf_fac1.setVisible(true);
        
        this.jf_fac1.jButtonBuscarFactura.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.jf_fac1.jButtonBuscarFactura)){
            if(Ctrl_validar.validaDato(this.jf_fac1.txtIngresarNumeroFactura.getText())){ 
                    int a = Integer.parseInt(this.jf_fac1.txtIngresarNumeroFactura.getText());
                       jf_fac1.TxtAreaFactura.setText(fDAO.imprimeFacturaDAO(fDAO.buscarFacturaDAO(a)));
            }else {JOptionPane.showMessageDialog(null, "DEBE INGRESAR SOLO NUMEROS");}
            
        }else{} 
    }
}
    

    
    

