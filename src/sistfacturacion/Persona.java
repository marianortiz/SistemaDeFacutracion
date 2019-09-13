
package sistfacturacion;

import java.util.ArrayList;


public abstract class Persona {
    
    protected String apellido;
    protected String direccion;
    protected String documento;
    protected String nombre;
    ArrayList<Comprobante> comprobante;
    //Constructor 
    public Persona() {
    }
    //consutructor sobrecargado
    public Persona(String apellido, String direccion, String documento, String nombre) {
        this.apellido = apellido;
        this.direccion = direccion;
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(ArrayList<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }
    
    
    
    
    
}
