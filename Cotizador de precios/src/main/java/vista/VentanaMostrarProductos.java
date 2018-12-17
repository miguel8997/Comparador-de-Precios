package vista;

import javax.swing.JFrame;

public class VentanaMostrarProductos extends JFrame{

    private TablaProductos panelTabla;

    public VentanaMostrarProductos() {
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        panelTabla = new TablaProductos();

        this.add(this.panelTabla);
        this.setSize(2000, 2000);
        this.setTitle("Productos encontrados");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    public TablaProductos getPanelTabla() {
        return panelTabla;
    }

    public void setPanelTabla(TablaProductos panelTabla) {
        this.panelTabla = panelTabla;
    }

   
}
