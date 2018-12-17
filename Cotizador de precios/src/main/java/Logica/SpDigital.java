package Logica;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class SpDigital extends PaginaWeb {

    public SpDigital(String url, String nombre) {
        super(url, nombre);
    }

    @Override
    public String editAEstructuraDePagina(String nombreProduc) {
        return "/categories/search?q=" + super.editAEstructuraDePagina(nombreProduc).replace(" ", "+") + "&category_id=-1";
    }

    @Override
    public ArrayList conectarPaginaPorBuscador(String urlProduc) throws IOException {

        ArrayList<String> paginas = saltoDePaginaBuscador(super.getUrl() + "" + urlProduc);
        ArrayList<Producto> almc = new ArrayList<>();
        paginas.remove(0);
        paginas.add(0, urlProduc);

        for (String pag : paginas) {

            Document doc = Jsoup.connect(super.getUrl() + "" + pag).get();
            Elements temp = doc.select("div.span2.product-item-mosaic");

            for (Element list : temp) {
                String url = list.select(".image a").attr("href");
                porductoSP(url);

                almc.add(porductoSP(url));

            }

        }

        return almc;

    }

    @Override
    public ArrayList conectarPaginaPorCategorias(String urlProduc) throws IOException {

        int cantidadPag = saltoDePaginaCategorias(urlProduc);

        ArrayList<Producto> almc = new ArrayList<>();

        for (int i = 1; i <= cantidadPag; i++) {

            Document doc = Jsoup.connect(super.getUrl() + "" + urlProduc + "/page:" + i).get();
            Elements temp = doc.select("div.span2.product-item-mosaic");

            for (Element list : temp) {
                String url = list.select(".image a").attr("href");
                porductoSP(url);

                almc.add(porductoSP(url));

            }
        }

        return almc;

    }

    private Producto porductoSP(String url) throws IOException {

        Document doc = Jsoup.connect(super.getUrl() + url).get();
        Elements temp = doc.select("div.product-view");

        String nombreProduc = temp.select("div.span7 h1").text();
        String precio = temp.select("div.right-stuff-container div.product-view-cash-price-div.product-view-cash-price.text-webstore").text();
        String PrecioEnInt = temp.select("div.right-stuff-container div.product-view-cash-price-div.product-view-cash-price.text-webstore").text();

        PrecioEnInt = PrecioEnInt.replace(".", "");
        PrecioEnInt = PrecioEnInt.replace("$", "");
        int PrecioAInt = Integer.parseInt(PrecioEnInt);
        Producto pro = new Producto(nombreProduc, "Precio Efectivo " + precio, getNombre(), PrecioAInt);

        return pro;

    }

    public ArrayList<String> saltoDePaginaBuscador(String link) throws IOException {
        ArrayList<String> paginas = new ArrayList();
        Document doc = Jsoup.connect(link).get();
        Elements temp = doc.select("div.pagination li");

        for (Element list : temp) {
            String urls = list.select("a").attr("href");
            paginas.add(urls);
        }
        return paginas;
    }

    public int saltoDePaginaCategorias(String link) throws IOException {

        ArrayList<String> paginas = new ArrayList();
        Document doc = Jsoup.connect(super.getUrl() + link).get();
        Elements temp = doc.select("div.pagination li.next");

        String url = temp.select("a").attr("href");
        url = url.replace(link + "/page:", "");
        int catidadPag = Integer.parseInt(url);
        return catidadPag;
    }

}
