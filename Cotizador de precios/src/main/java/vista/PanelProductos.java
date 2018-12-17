package vista;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelProductos extends JPanel implements MouseListener {

    private JButton btn1;
    private ImageIcon iconBtn1 = new ImageIcon("src/main/java/recursos/ofertas1.jpg");
    private JButton btn2;
    private ImageIcon iconBtn2 = new ImageIcon("src/main/java/recursos/ofertas2.jpg");
    private JButton btn3;
    private ImageIcon iconBtn3 = new ImageIcon("src/main/java/recursos/ofertas3.jpg");
    private JButton btn4;
    private ImageIcon iconBtn4 = new ImageIcon("src/main/java/recursos/ofertas4.jpg");
    
    private ImageIcon iconBtnIzquierda = new ImageIcon("src/main/java/recursos/btnIzquierda.jpg");
    private ImageIcon iconBtnDerecha = new ImageIcon("src/main/java/recursos/btnDerecha.jpg");
    private JButton btnAvanzar;
    private JButton btnRetroceder;
    static int contador = 0;

    public PanelProductos(JButton avanzar, JButton retroceder) {
        this.btnAvanzar = avanzar;
        this.btnRetroceder = retroceder;
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.btnAvanzar.addMouseListener(this);
        this.btnAvanzar.setIcon(iconBtnDerecha);
        this.btnRetroceder.addMouseListener(this);
        this.btnRetroceder.setIcon(iconBtnIzquierda);

        this.btn1 = new JButton();
        this.btn1.setBounds(0, 150, 700, 350);
        this.btn1.setIcon(iconBtn1);
        this.add(btn1);
        this.btn1.addMouseListener(this);

        this.btn2 = new JButton();
        this.btn2.setBounds(-700, 150, 700, 350);
        this.btn2.setIcon(iconBtn2);
        this.add(btn2);
        this.btn2.addMouseListener(this);

        this.btn3 = new JButton();
        this.btn3.setBounds(-700, 150, 700, 350);
        this.btn3.setIcon(iconBtn3);
        this.add(btn3);
        this.btn3.addMouseListener(this);

        this.btn4 = new JButton();
        this.btn4.setBounds(0, 150, 700, 350);
        this.btn4.setIcon(iconBtn4);
        this.add(btn4);
        this.btn4.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.btnAvanzar && contador == 0) {
            Animacion.Animacion.mover_derecha(0, 700, 0, WIDTH, btn1);
            Animacion.Animacion.mover_derecha(-700, 0, 0, WIDTH, btn2);
            contador = 1;
        } else if (e.getSource() == this.btnAvanzar && contador == 1) {
            Animacion.Animacion.mover_derecha(0, 700, 0, WIDTH, btn2);
            Animacion.Animacion.mover_derecha(-700, 0, 0, WIDTH, btn3);
            contador = 2;
        } else if (e.getSource() == this.btnAvanzar && contador == 2) {
            Animacion.Animacion.mover_derecha(0, 700, 0, WIDTH, btn3);
            Animacion.Animacion.mover_derecha(-700, 0, 0, WIDTH, btn4);
            contador = 3;
        } else if (e.getSource() == this.btnAvanzar && contador == 3) {
            Animacion.Animacion.mover_derecha(0, 700, 0, WIDTH, btn4);
            Animacion.Animacion.mover_derecha(-700, 0, 0, WIDTH, btn1);
            contador = 0;
        }
        if (e.getSource() == this.btnRetroceder && contador == 0) {
            Animacion.Animacion.mover_izquierda(0, -700, 0, WIDTH, btn1);
            Animacion.Animacion.mover_izquierda(700, 0, 0, WIDTH, btn4);
            contador = 3;
        } else if (e.getSource() == this.btnRetroceder && contador == 3) {
            Animacion.Animacion.mover_izquierda(0, -700, 0, WIDTH, btn4);
            Animacion.Animacion.mover_izquierda(700, 0, 0, WIDTH, btn3);
            contador = 2;
        } else if (e.getSource() == this.btnRetroceder && contador == 2) {
            Animacion.Animacion.mover_izquierda(0, -700, 0, WIDTH, btn3);
            Animacion.Animacion.mover_izquierda(700, 0, 0, WIDTH, btn2);
            contador = 1;
        } else if (e.getSource() == this.btnRetroceder && contador == 1) {
            Animacion.Animacion.mover_izquierda(0, -700, 0, WIDTH, btn2);
            Animacion.Animacion.mover_izquierda(700, 0, 0, WIDTH, btn1);
            contador = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.btn1) {
            abrirLink("https://www.pcfactory.cl/producto/31328-Imbatible");
        }else if (e.getSource() == this.btn2) {
            abrirLink("https://www.spdigital.cl/s/msi");
        }else if (e.getSource() == this.btn3) {
            abrirLink("https://www.pcfactory.cl/ninos-tecnologicos");
        }else if (e.getSource() == this.btn4) {
            abrirLink("https://www.spdigital.cl/s/nvidia");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void abrirLink(String link) {
        try{
            Desktop.getDesktop().browse(new URI(link));
        }catch(Exception e){
            
        };
    }

}
