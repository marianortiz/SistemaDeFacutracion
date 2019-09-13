
package sistfacturacion;


public class Vendedor extends Persona{
   private int idVendedor;
   private String sector;
   
    //constructor
    public Vendedor() {
    }

    //constructor sobrecargado
    public Vendedor(int idVendedor, String sector, String apellido, String direccion, String documento, String nombre) {
        super(apellido, direccion, documento, nombre);
        this.idVendedor = idVendedor;
        this.sector = sector;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void agregarFacutra(Factura f){
        comprobante.add(f);
    }
   
   
    
}
