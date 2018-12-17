
package vista;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablaProductos extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    

    public TablaProductos() {
        this.inicializarComponente();
    }

    private void inicializarComponente() {
         this.setLayout(null);
        this.modelo = new DefaultTableModel();
        
        this.tabla=new JTable();
        this.tabla.setModel(modelo);
        this.tabla.setRowHeight(50);
        this.modelo.addColumn("Pagina");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Precio"); 
        this.scroll = new JScrollPane(this.tabla);
        this.scroll.setBounds(0,0,1350,748);
        this.add(scroll);
        

    }
    
    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JTable getTabla() {
        return tabla;
    }
    
}