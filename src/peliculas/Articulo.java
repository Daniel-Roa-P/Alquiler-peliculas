
package peliculas;

//clase que representa los balores basicos de una pelicula a la venta

public class Articulo {
    
    private String nombreProducto;
    private int precioProducto;
    
    Articulo(String nombreProducto, int precioProducto){
    
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        
        
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
    
}
