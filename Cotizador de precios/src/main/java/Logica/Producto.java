package Logica;

public class Producto implements Comparable<Producto> {

    private String nombre;
    private String precio;
    private String pagina;
    private int precioEnInt;

    public Producto(String nombre, String precio, String pagina, int precioEnInt) {
        this.nombre = nombre;
        this.precio = precio;
        this.pagina = pagina;
        this.precioEnInt = precioEnInt;
    }
    
    @Override
    public int compareTo(Producto e) {
        if (e.getPrecioEnInt() > precioEnInt) {
            return -1;
        } else if (e.getPrecioEnInt() > precioEnInt) {
            return 0;
        } else {
            return 1;
        }

    }

    public int getPrecioEnInt() {
        return precioEnInt;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPagina() {
        return pagina;
    }

}
