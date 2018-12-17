
package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesOfertas extends JPanel  {

    private JButton btn;
    public PanelBotonesOfertas() {
        inicializarComponentes();
    }
    private void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.btn=new JButton();
        this.btn.setBounds(0,280,30,28);
        this.add(btn);
        
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }
   
}
