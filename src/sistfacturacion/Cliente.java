
package sistfacturacion;


public class Cliente extends Persona{
    
    private int telefono;

    public Cliente() {
    }

    public Cliente(int telefono, String apellido, String direccion, String documento, String nombre) {
        super(apellido, direccion, documento, nombre);
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void agregarFacutra(Factura f){
        comprobante.add(f);
    }
    
}
