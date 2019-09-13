
package datos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistfacturacion.Cliente;
import sistfacturacion.Factura;
import sistfacturacion.Producto;
import sistfacturacion.Vendedor;


public class FacturaDAO extends SQLQuery{

    public FacturaDAO() {
        try {
            this.conectar("127.0.0.1","sistemadefacturacion","root","");
            System.out.println("conexion");
            
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Factura buscarFacturaDAO(int num){
        Factura fact1 = null ;
        try {
            this.consulta =  this.conn.prepareStatement("SELECT f.`fact_numero`, f.`fact_fecha`, f.`fact_tipoFactura`, df.`detalle_cantidad`, prod.`prod_nombre`, prod.`prod_precio`, prod.`prod_id`, persona_c.`per_tipo`, persona_c.`per_nombre`, persona_c.`per_apellido`, persona_c.`per_documento`, persona_c.`per_direccion`, cli.`cli_telefono`, persona_v.`per_tipo`, persona_v.`per_nombre`, persona_v.`per_apellido`, persona_v.`per_documento`, persona_v.`per_direccion`, vend.`vend_sector`, vend.`vend_id` FROM `factura` f, `Cliente` cli, `persona` persona_c, `persona` persona_v, `detalleFactura` df, `producto` prod, `persona_factura` pf1 ,`persona_factura` pf2, `vendedor` vend WHERE f.`fact_id` = df.`fact_id_fk` AND df.`prod_id_fk` = prod.`prod_id` AND pf1.`fact_id_fk` = f.`fact_id` AND persona_c.`per_id` = pf1.`per_id_fk` AND cli.`per_id_fk` = persona_c.`per_id` AND pf2.`fact_id_fk` = f.`fact_id` AND persona_v.`per_id` = pf2.`per_id_fk` AND vend.`per_id_fk` = persona_v.`per_id` AND f.`fact_numero` = ?");
            this.consulta.setInt(1, num);
            this.datos =  this.consulta.executeQuery();
            
            while(this.datos.next()){
                
                Cliente c1 = new Cliente();
                
                c1.setNombre(this.datos.getString("per_nombre"));
                c1.setApellido(this.datos.getString("per_apellido"));
                c1.setDocumento(this.datos.getString("per_documento"));
                c1.setDireccion(this.datos.getString("per_direccion"));
                c1.setTelefono(this.datos.getInt("cli_telefono"));
                
                Vendedor v1 = new Vendedor();
                
                v1.setNombre(this.datos.getString(15));
                v1.setApellido(this.datos.getString(16));
                v1.setDocumento(this.datos.getString(17));
                v1.setDireccion(this.datos.getString(18));
                v1.setIdVendedor(this.datos.getInt("vend_id"));
                v1.setSector(this.datos.getString("vend_sector"));
                
                fact1 = new Factura();
                
                fact1.setTipoFactura(this.datos.getString("fact_tipoFactura"));
                fact1.setNumeroComprobante(this.datos.getInt("fact_numero"));
                fact1.setFechaComprobante(this.datos.getString("fact_fecha"));
                
                fact1.agregarCliente(c1);
                fact1.agregarVendedor(v1);
                
                
                do{
                    Producto prod = new Producto();
                    prod.setIdProducto(this.datos.getInt("prod_id"));
                    prod.setNombreProducto(this.datos.getString("prod_nombre"));
                    prod.setPrecioUnitario(this.datos.getFloat("prod_precio"));
                    fact1.agregarLineaDetalleProducto(prod, this.datos.getInt(4));
                
                }while(this.datos.next());
                desconectar(this.datos);
            }   
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "factura inexistente");
        }
        return fact1;
    }
    
    public String imprimeFacturaDAO(Factura f){
        String impimimir = f.mostrarEncabezado()+"\n"+f.imprimeDetalle();
        return impimimir;
    }
    
    
}
