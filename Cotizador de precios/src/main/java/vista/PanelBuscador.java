
package vista;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelBuscador extends JPanel  {
    
    private JButton btnBuscar;
    private JTextField tfBuscar;
    private ImageIcon iconBuscar = new ImageIcon("src/main/java/recursos/SEARCH1.jpg");

    public PanelBuscador() {
        inicializarComponentes();
    }
    
    public void inicializarComponentes(){
        this.setLayout(null);

        this.setBackground(Color.BLACK);
        this.tfBuscar =new JTextField();
        this.tfBuscar.setBounds(261, 10, 400, 25);
        this.add(this.tfBuscar);
        
        this.btnBuscar = new JButton();
        this.btnBuscar.setBounds(671,6, 30, 30);
        this.btnBuscar.setIcon(iconBuscar);
        this.btnBuscar.setBorder(null);
        this.btnBuscar.setBorderPainted(false);
        this.add(this.btnBuscar);
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getTfBuscar() {
        return tfBuscar;
    }

    public ImageIcon getIconBuscar() {
        return iconBuscar;
    }

    
}
