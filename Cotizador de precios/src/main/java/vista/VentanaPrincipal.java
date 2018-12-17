package vista;

import Logica.Producto;
import Logica.ProductosEncontrados;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelBuscador panelSuperior;
    private PanelProductos panelCentral;
    private PanelCategorias panelLateral;
    private PanelBotonesOfertas panelAvanzar;
    private PanelBotonesOfertas panelRetroceder;

    public VentanaPrincipal() {
        inicializarComponente();
    }
    
    static int contador=0;

    public void inicializarComponente() {
        this.setLayout(null);
        
        this.panelAvanzar=new PanelBotonesOfertas();
        this.panelRetroceder=new PanelBotonesOfertas();
        this.panelLateral = new PanelCategorias();
        this.panelSuperior = new PanelBuscador();
        this.panelCentral = new PanelProductos(this.panelAvanzar.getBtn(),this.panelRetroceder.getBtn());  
        

        this.panelSuperior.setPreferredSize(new Dimension(500,45));
        this.panelLateral.setPreferredSize(new Dimension(232, 1000));
        this.panelAvanzar.setPreferredSize(new Dimension(30,800));
        this.panelRetroceder.setPreferredSize(new Dimension(30,800));

        
        this.add(this.panelSuperior).setBounds(0, 0, 1000,45);
        this.add(this.panelLateral).setBounds(0, 45, 232, 1000);  
        this.add(this.panelCentral).setBounds(261, 35, 700,800);
        this.add(this.panelRetroceder).setBounds(231, 45, 30,800);
        this.add(this.panelAvanzar).setBounds(961, 45, 30,800);
        
        this.setSize(997, 700);
        this.setTitle("Lista de productos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panelLateral.getBtnSonido().addActionListener(this);
        panelLateral.getBtnNotebooks().addActionListener(this);
        panelLateral.getBtnPlacaMadre().addActionListener(this);
        panelLateral.getBtnProcesador().addActionListener(this);
        panelLateral.getBtnSmartphones().addActionListener(this);
        panelLateral.getBtnTelevisores().addActionListener(this);
        panelLateral.getBtnHardware().addActionListener(this);
        panelLateral.getBtnAccesorios().addActionListener(this);
        panelSuperior.getBtnBuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (panelLateral.getBtnSonido() == ae.getSource()) {
            try {
                tabla("/equipos-de-musica?categoria=889&papa=268", "/categories/view/360");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnNotebooks()== ae.getSource()){
            try {
                tabla("/notebooks?categoria=735&papa=636", "/categories/view/370");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnPlacaMadre()== ae.getSource()){
            try {
                tabla("/placas-madres?categoria=292&papa=633 ", "/categories/view/377");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnProcesador()== ae.getSource()){
            try {
                tabla("/procesadores?categoria=272&papa=633 ", "/categories/view/378");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnSmartphones()== ae.getSource()){
            try {
                tabla("/smartphones?categoria=432&papa=645", "/categories/view/459");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnTelevisores()== ae.getSource()){
            try {
                tabla("/tv-y-smart-tv?categoria=789&papa=788", "/categories/view/417");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnHardware()== ae.getSource()){
            try {
                tabla("/accesorios-notebooks?categoria=56&papa=296", "/cargadores");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(panelLateral.getBtnAccesorios()== ae.getSource()){
            try {
                tabla("/accesorios-proyectores?categoria=439&papa=256", "/categories/view/418");
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (this.panelSuperior.getBtnBuscar()==ae.getSource()) {
            try {
                VentanaMostrarProductos p=new VentanaMostrarProductos();
                ProductosEncontrados b=new ProductosEncontrados();
                ArrayList<Producto> almcTodo =b.Buscador(this.panelSuperior.getTfBuscar().getText());
                Object[] fila = new Object[3];
                for (int i = 0; i < almcTodo.size(); i++) {
                    fila[0] = almcTodo.get(i).getPagina();
                    fila[1] = almcTodo.get(i).getNombre();
                    fila[2] = almcTodo.get(i).getPrecio();
                    p.getPanelTabla().getModelo().addRow(fila);
                }
                p.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(PanelBuscador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void tabla(String PC, String SP) throws IOException {
        VentanaMostrarProductos v = new VentanaMostrarProductos();
        v.setVisible(true);
        ProductosEncontrados p=new ProductosEncontrados();
        ArrayList<Producto> almcTodo = p.Categoria(PC, SP);

        Object[] fila = new Object[3];
        for (int i = 0; i < almcTodo.size(); i++) {
            fila[0] = almcTodo.get(i).getPagina();
            fila[1] = almcTodo.get(i).getNombre();
            fila[2] = almcTodo.get(i).getPrecio();
            v.getPanelTabla().getModelo().addRow(fila);
        }
        v.setVisible(true);
        
    }
}
