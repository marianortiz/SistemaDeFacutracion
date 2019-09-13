
package sistfacturacion;

import java.util.ArrayList;


public class DetalleFactura {
    
    private int cantidad;
    private Producto producto;
    private Factura factura;
    
    //CONSTRUCTOR DE DETALLE FACTURA
    public DetalleFactura() {
    }
    
    //CONSTRUCTOR DE DETALLE FACTURA SOBRECARGADO
    public DetalleFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    
    public Long buscarProducto(){
       return producto.getIdProducto();
    }
    
    public String buscarProductoDescripcion(){
       return producto.getNombreProducto();
    }
    
    public double buscarProductoPrecio (){
        return producto.getPrecioUnitario();
    }
    
    public double calcularSubtotal(){
        return producto.getPrecioUnitario() * cantidad;
        
    }
    
    
    
    //GETTER AND SETTER
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
    
    
    
    
    
}
