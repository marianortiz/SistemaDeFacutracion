

package sistfacturacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public abstract class Comprobante implements Dgi{
    
        //ATRIBUTOS
    private String fecha;
    private int numero;
    ArrayList<Persona> personas = new ArrayList<>();
    
    
        //BUSCA UN CLIENTE EN EL ARRAYLIST Personas
    public String buscarCliente(){
        String nombre = null;
        for(int i=0;i < personas.size();i++){
            if( personas.get(i) instanceof Cliente){
              nombre = personas.get(i).getNombre() + "   " + personas.get(i).getApellido();
            }
        }
        return nombre;
    }   
           
        //BUSCA LA DIRECCION DE UNA PERSONA EN EL ARRAYLIS Personas
    public String BuscarClienteDireccion(){
        String direccion =  null;
        for(int i=0; i <  personas.size(); i++){
            if (personas.get(i) instanceof Cliente){
                direccion = personas.get(i).getDireccion();
            }
        }
    return direccion;
    }
        
        //BUSCA UN VENDEDOR EN EL ARRAYLIST Personas
    public String buscarVendedor(){
        String nombreV =  null;
        for(int i=0; i < personas.size(); i++)
            if (personas.get(i) instanceof Vendedor){
                nombreV = personas.get(i).getNombre() +"    "+personas.get(i).getApellido();
            }
    return nombreV;
    }
    
        //CONSTRUCTOR SOBRECARGADO DE COMPROBANTE
    public Comprobante(String fecha, int numero) {
        this.fecha = fecha;
        this.numero = numero;
    }
    
        //CONSTRUCTOR POR DEFECTO DE COMPROBANTE
    public Comprobante() {
        
    }
        
        //GETTER AND SETTER
    public String getFechaComprobante(String fecha) {
        
        this.fecha = fecha;
        
        return fecha; 
    }

    public void setFechaComprobante(String fecha) {
        this.fecha = fecha;
    }

    public int debeTenerNumero() {
        return numero;
    }

    public void setNumeroComprobante(int numero) {
        this.numero = numero;
    }
    
    public String debeTenerFecha(){
        return fecha;
    }
     
    
    public abstract String debeTenerTipoComprobante();
    public abstract String debeTenerTitular();
    public abstract double debeTenerTotal();
    
}   

