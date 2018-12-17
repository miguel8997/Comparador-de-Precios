package Logica;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class PcFactory extends PaginaWeb {

    public PcFactory(String url, String nombre) {
        super(url, nombre);
    }

    @Override
    public String editAEstructuraDePagina(String nombreProduc) {
        return "/buscar?valor=" + super.editAEstructuraDePagina(nombreProduc).replace(" ", "%20");
    }

    @Override
    public ArrayList conectarPaginaPorBuscador(String urlProduc) throws IOException {
        ArrayList<Producto> almc = new ArrayList<>();

        Document doc = Jsoup.connect(super.getUrl() + "" + urlProduc).get();
        Elements temp = doc.select("div.wrap-caluga-matrix");

        for (Element list : temp) {

            String url = list.select("div.center-caluga a").attr("href");
            porductoPC(url);

            almc.add(porductoPC(url));
        }
        
        return almc;
    }

    @Override
    public ArrayList conectarPaginaPorCategorias(String urlProduc) throws IOException {
        int cantPag = saltoDePaginaCategorias(urlProduc);
        ArrayList<Producto> almc = new ArrayList<>();

        for (int i = 1; i <= cantPag; i++) {
            Document doc = Jsoup.connect(super.getUrl() + "" + urlProduc + "&pagina=" + i).get();
            Elements temp = doc.select("div.wrap-caluga-matrix");
            
            for (Element list : temp) {

                String url = list.select("div.center-caluga a").attr("href");
                porductoPC(url);

                almc.add(porductoPC(url));
            }
        }
        return almc;
    }

    private Producto porductoPC(String url) throws IOException {

        Document doc = Jsoup.connect(super.getUrl() + url).get();
        Elements temp = doc.select("div.ficha_cuerpo");

        String title = temp.select("div.ficha_titulos h1").text();
        String precio1 = temp.select("div.ficha_precio_efectivo").text();
        String precioEnInt = temp.select("div.ficha_precio_efectivo h2").text();
        precioEnInt = precioEnInt.replace(".", "");
        precioEnInt = precioEnInt.replace("$ ", "");
        int PrecioAInt = Integer.parseInt(precioEnInt);

        Producto pro = new Producto(title,precio1,getNombre(), PrecioAInt);
        return pro;

    }

    public int saltoDePaginaCategorias(String link) throws IOException {

        ArrayList<String> paginas = new ArrayList();
        Document doc = Jsoup.connect(super.getUrl() + link).get();
        Elements temp = doc.select("div.categoria-paginador-bottom");
        String cantPag = temp.select("li span#pag_ter2").text();
        int catidadPag = Integer.parseInt(cantPag);
        return catidadPag;
    }

}
