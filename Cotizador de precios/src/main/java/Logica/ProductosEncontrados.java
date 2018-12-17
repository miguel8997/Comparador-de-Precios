package Logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ProductosEncontrados {

    private PaginaWeb paginaSP;
    private PaginaWeb paginaPC;

    public ProductosEncontrados() {
        this.paginaSP = new SpDigital("https://www.spdigital.cl", "SPDIGITAL");
        this.paginaPC = new PcFactory("https://www.pcfactory.cl", "PCFACTORY");

    }

    public ArrayList<Producto> Buscador(String nombProduc) throws IOException {

        ArrayList<Producto> almcTodo = new ArrayList<>();
        ArrayList<Producto> almcPC = new ArrayList<>();
        ArrayList<Producto> almcSP = new ArrayList<>();

        almcPC = this.paginaPC.conectarPaginaPorBuscador(paginaPC.editAEstructuraDePagina(nombProduc));
        almcSP = this.paginaSP.conectarPaginaPorBuscador(paginaSP.editAEstructuraDePagina(nombProduc));

        for (Producto produc : almcPC) {
            almcTodo.add(produc);
        }
        for (Producto produc : almcSP) {
            almcTodo.add(produc);
        }

        Collections.sort(almcTodo);
        return almcTodo;
    }

    public ArrayList Categoria(String PC, String SP) throws IOException {

        ArrayList<Producto> almcTodo = new ArrayList<>();

        ArrayList<Producto> almcPC = new ArrayList<>();
        ArrayList<Producto> almcSP = new ArrayList<>();

        almcPC = this.paginaPC.conectarPaginaPorCategorias(PC);
        almcSP = this.paginaSP.conectarPaginaPorCategorias(SP);

        for (Producto produc : almcPC) {
            almcTodo.add(produc);
        }
        for (Producto produc : almcSP) {
            almcTodo.add(produc);
        }

        Collections.sort(almcTodo);
        return almcTodo;
    }

}
