/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Logica.Producto;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ito_r
 */
public class testLogica {

    @Test
    public void testVerificarSiFuncionanLasCategorias() throws IOException {

        //para verficar ingrese a: https://www.spdigital.cl/categories/view/360
        //                         https://www.pcfactory.cl/equipos-de-musica?categoria=889&papa=268
         Logica.ProductosEncontrados c = new Logica.ProductosEncontrados();
         ArrayList<Logica.Producto> almcTodo = c.Categoria("/equipos-de-musica?categoria=889&papa=268", 
                                                          "/categories/view/360");//Categoria sonido

        int valorEsperado = 25;  //Cantidad Productos esperados 
        int valorObtenido = almcTodo.size();//Cantidad total de preductos encontradas entre las 2 paginas web

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void TestVerificarSiFuncionaElBuscador() throws IOException {

        //para verficar ingrese a: https://www.spdigital.cl/categories/search?q=NVIDIA+GT710&category_id=-1
        //                         https://www.pcfactory.cl/buscar?valor=NVIDIA%20GT710
        Logica.ProductosEncontrados b = new Logica.ProductosEncontrados();
        ArrayList<Logica.Producto> almcTodo = b.Buscador("NVIDIA GT710");
        //Vericando la cantidad de productos encontrados al ingresar en el buscador

        int valorEsperado = 6;  // Cantidad Productos esperados 
        int valorObtenido = almcTodo.size();//Cantidad total de preductos encontradas entre las 2 paginas web

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void testVerificarSiSacaLosProductosDeLasPaginas() throws IOException {

        //para verficar ingrese a: https://www.spdigital.cl/categories/view/360
        //                         https://www.pcfactory.cl/equipos-de-musica?categoria=889&papa=268
        Logica.ProductosEncontrados c = new Logica.ProductosEncontrados();
        ArrayList<Logica.Producto> almcTodo = c.Categoria("/equipos-de-musica?categoria=889&papa=268", 
                                                          "/categories/view/360");//Categoria sonido 

        Logica.Producto p = new Producto("AIWA® Microcomponente AMC-282 Bluetooth", "Precio Oferta Efectivo $ 23.990", "PCFACTORY", 23990);

        String nombreProEsperado = p.getNombre();
        //Como los productos encontrados los ordena de menor a mayor
        //estoy verificando si de la categoria sonido saca el producto con precio mas bajo
        //Se comparan los nombres
        String nombreProObtenido = almcTodo.get(0).getNombre();//nombre producto con precio mas bajo
        
        assertEquals(nombreProEsperado, nombreProObtenido);

    }

}
