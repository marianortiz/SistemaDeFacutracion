
package sistfacturacion;


public class Producto {
    
    private long idProducto;
    private String nombreProducto;
    private double precioUnitario;

    public Producto() {
    }

    public Producto(long idProducto, String nombreProducto, double precioUnitario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    
    
}
