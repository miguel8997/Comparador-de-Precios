
package vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelCategorias extends JPanel implements MouseListener {

    ImageIcon iconNotebooks = new ImageIcon("src/main/java/recursos/NOTEBOOKS.png");
    ImageIcon iconAccesorios = new ImageIcon("src/main/java/recursos/Accesorios.png");
    ImageIcon iconHardware = new ImageIcon("src/main/java/recursos/HARDWARE.png");
    ImageIcon iconSonido = new ImageIcon("src/main/java/recursos/SONIDO.png");
    ImageIcon iconPlacaMadre = new ImageIcon("src/main/java/recursos/plantillaBotonPlacaMadre.png");
    ImageIcon iconProcesador = new ImageIcon("src/main/java/recursos/plantillaBotonprocesador.jpg");
    ImageIcon iconTelevisores = new ImageIcon("src/main/java/recursos/plantillaBotonTelevisor.jpg");
    ImageIcon iconSmartphones = new ImageIcon("src/main/java/recursos/plantillaBotonCelular.jpg");
    private JButton btnNotebooks;
    private JButton btnAccesorios;
    private JButton btnHardware;
    private JButton btnSonido;
    private JButton btnPlacaMadre;
    private JButton btnProcesador;
    private JButton btnTelevisores;
    private JButton btnSmartphones;

    public PanelCategorias() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

//btnNotebooks
        this.btnNotebooks = new JButton();
        this.btnNotebooks.setIcon(iconNotebooks);
        this.btnNotebooks.setBounds(-175, 10, 229, 61);
        add(this.btnNotebooks);
        btnNotebooks.addMouseListener(this);

        //btnAccesorios
        this.btnAccesorios = new JButton();
        this.btnAccesorios.setIcon(iconAccesorios);
        add(btnAccesorios);
        this.btnAccesorios.setBounds(-175, 80, 229, 61);

        btnAccesorios.addMouseListener(this);

        //btnHardware
        this.btnHardware = new JButton();
        this.btnHardware.setIcon(iconHardware);
        add(btnHardware);
        this.btnHardware.setBounds(-175, 150, 229, 61);

        btnHardware.addMouseListener(this);

        //btnSonido
        this.btnSonido = new JButton();
        this.btnSonido.setIcon(iconSonido);
        add(btnSonido);
        this.btnSonido.setBounds(-175, 220, 229, 61);

        btnSonido.addMouseListener(this);
        
        //btnplacamadre
        this.btnPlacaMadre = new JButton();
        this.btnPlacaMadre.setIcon(iconPlacaMadre);
        add(btnPlacaMadre);
        this.btnPlacaMadre.setBounds(-175, 290, 229, 61);

        btnPlacaMadre.addMouseListener(this);
        
        //btnSmartphones
        this.btnSmartphones = new JButton();
        this.btnSmartphones.setIcon(iconSmartphones);
        add(btnSmartphones);
        this.btnSmartphones.setBounds(-175, 360, 229, 61);

        btnSmartphones.addMouseListener(this);
        
        //btnProcesador
        this.btnProcesador = new JButton();
        this.btnProcesador.setIcon(iconProcesador);
        add(btnProcesador);
        this.btnProcesador.setBounds(-175, 430, 229, 61);

        btnProcesador.addMouseListener(this);
        
        //btnTelevisores
        this.btnTelevisores = new JButton();
        this.btnTelevisores.setIcon(iconTelevisores);
        add(btnTelevisores);
        this.btnTelevisores.setBounds(-175, 500, 229, 61);

        btnTelevisores.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == btnNotebooks) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnNotebooks);
        }  if (e.getSource() == btnAccesorios) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnAccesorios);
        }  if (e.getSource() == btnHardware) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnHardware);
        }  if (e.getSource() == btnSonido) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnSonido);
        }  if (e.getSource() == btnPlacaMadre) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnPlacaMadre);
        }  if (e.getSource() == btnSmartphones) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnSmartphones);
        }  if (e.getSource() == btnProcesador) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnProcesador);
        }  if (e.getSource() == btnTelevisores) {
            Animacion.Animacion.mover_derecha(-175, 0, 1, 2, this.btnTelevisores);
        }
    }
    

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnNotebooks) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnNotebooks);
        } if (e.getSource() == btnAccesorios) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnAccesorios);
        } if (e.getSource() == btnHardware) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnHardware);
        } if (e.getSource() == btnSonido) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnSonido);
        } if (e.getSource() == btnPlacaMadre) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnPlacaMadre);
        }  if (e.getSource() == btnSmartphones) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnSmartphones);
        }  if (e.getSource() == btnProcesador) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnProcesador);
        }  if (e.getSource() == btnTelevisores) {
            Animacion.Animacion.mover_izquierda(0, -175, 1, 2, this.btnTelevisores);
        }
    }

    public JButton getBtnNotebooks() {
        return btnNotebooks;
    }

    public void setBtnNotebooks(JButton btnNotebooks) {
        this.btnNotebooks = btnNotebooks;
    }

    public JButton getBtnAccesorios() {
        return btnAccesorios;
    }

    public void setBtnAccesorios(JButton btnAccesorios) {
        this.btnAccesorios = btnAccesorios;
    }

    public JButton getBtnHardware() {
        return btnHardware;
    }

    public void setBtnHardware(JButton btnHardware) {
        this.btnHardware = btnHardware;
    }

    public JButton getBtnSonido() {
        return btnSonido;
    }

    public void setBtnSonido(JButton btnSonido) {
        this.btnSonido = btnSonido;
    }

    public JButton getBtnPlacaMadre() {
        return btnPlacaMadre;
    }

    public void setBtnPlacaMadre(JButton btnPlacaMadre) {
        this.btnPlacaMadre = btnPlacaMadre;
    }

    public JButton getBtnProcesador() {
        return btnProcesador;
    }

    public void setBtnProcesador(JButton btnProcesador) {
        this.btnProcesador = btnProcesador;
    }

    public JButton getBtnTelevisores() {
        return btnTelevisores;
    }

    public void setBtnTelevisores(JButton btnTelevisores) {
        this.btnTelevisores = btnTelevisores;
    }

    public JButton getBtnSmartphones() {
        return btnSmartphones;
    }

    public void setBtnSmartphones(JButton btnSmartphones) {
        this.btnSmartphones = btnSmartphones;
    }
    
    
}
