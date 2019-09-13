
package sistfacturacion;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import datos.FacturaDAO;
import java.sql.SQLException;
import java.util.ArrayList;


public class Factura extends Comprobante{
    
    private String tipoFactura;
    ArrayList<DetalleFactura> detalleFactura;   
    private FacturaDAO facturaDAO;
    
    
    //CONSTRUCTOR DE FACTURA
    public Factura() {
    }
    
    //CONSTRUCTOR DE FACTURA SOBRECARGADO
    public Factura(String tipoFactura, String fecha, int numero, Persona cliente, Persona vendedor) { 
        super(fecha, numero);
        this.tipoFactura = tipoFactura;
        detalleFactura = new ArrayList<>();
        
        personas.add(cliente);
        personas.add(vendedor);
    }
    
    // GETTER Y SETTER
    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public ArrayList<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(ArrayList<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    
    //METODOS
    
    public void agregarLineaDetalleProducto(Producto xproducto, int cantidad){
        DetalleFactura lineaDetalle = new DetalleFactura();
            lineaDetalle.setCantidad(cantidad);
            lineaDetalle.setProducto(xproducto);
            detalleFactura.add(lineaDetalle);
    }
    
    
    public String debeTenerTipoComprobante(){
        return tipoFactura;
    }
    
    public String debeTenerTitular(){
        for(int i = 0; i<= personas.size(); i++)
            if (personas.get(i) instanceof Cliente){
                String titular = personas.get(i).getNombre() + " " + personas.get(i).getApellido();
                return titular;
            }
    return "no existe titular";
    }
    
    
    public double debeTenerTotal(){
        double total = 0.0;
        for(int i = 0; i < detalleFactura.size() ; i++){
            total = total + detalleFactura.get(i).calcularSubtotal();
        }
        return total;
    
    }

    
    public String imprimeDetalle(){
        String detalleimp = 
        "-----------------Detalle-----------------------\n"
        +"Codigo  Descripcion  Cant  Precio"+"\n";

        for(int i=0; i<this.getDetalleFactura().size(); i++){
                DetalleFactura detalle = (DetalleFactura) (this.getDetalleFactura().get(i));
        
        detalleimp +=         
        +detalle.buscarProducto()+"     "
        +detalle.buscarProductoDescripcion()+"          "
        +detalle.getCantidad()+"      "
        +detalle.buscarProductoPrecio()+"\n";
                
            }
        detalleimp += "                      Total: "+this.debeTenerTotal();

    return detalleimp;
    }    
    
    public String mostrarEncabezado(){
        String encabezado =     
       "--------------Java----------------\n"
       +"             Factura tipo "+this.getTipoFactura()+"\n"
       +"Nro.: "+ this.debeTenerNumero()+"\n"
       +"  Fecha: "+ this.debeTenerFecha()+"\n"
       +"-----------------Cliente-----------------------"
       +this.buscarCliente()+"\n"

       +this.BuscarClienteDireccion()+"\n"

       +"-----------------Vendedor----------------------"+"\n"
       +this.buscarVendedor()+"\n";
        return encabezado;
    }

    public void imprimeFactura(){
        mostrarEncabezado();
        imprimeDetalle();
    }
    
    public void agregarCliente(Cliente c){
        personas.add(c);
    }
    
    public void agregarVendedor(Vendedor v){
        personas.add(v);
    }
    
    

}
    
    
    
    

    

    
    
    
   

    
    

