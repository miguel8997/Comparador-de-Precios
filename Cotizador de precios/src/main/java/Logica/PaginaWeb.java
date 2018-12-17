package Logica;

import java.io.IOException;
import java.util.ArrayList;

public class PaginaWeb {

    private String url;
    private String nombre;

    public PaginaWeb(String url, String nombre) {
        this.url = url;
        this.nombre = nombre;
    }

    public String editAEstructuraDePagina(String nombrePro) {
        return nombrePro;
    }

    public ArrayList conectarPaginaPorBuscador(String urlProduc) throws IOException {
        return null;
    }

    public ArrayList conectarPaginaPorCategorias(String urlProduc) throws IOException {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

}
