
package peliculas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Peliculas extends JFrame implements ActionListener {

    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    
    public JLabel label1 = new JLabel("Grafo:");
    public JLabel label2 = new JLabel("Matriz de adyacencia:");
    public JLabel label3 = new JLabel ("Numero cromatico: ");
    
    
    
    public static void main(String[] args) {
        
        Peliculas nc = new Peliculas(); 
        nc.setResizable(false);
        nc.setBounds(0, 0, 1300, 720);
        nc.setTitle("Numero Cromatico");
        nc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        nc.setVisible(true);
        
    }

    Peliculas(){
    
        scrollPane1.removeAll();
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        c.add(scrollPane);
        
        scrollPane.setBounds(0, 0, 1290, 680);
        scrollPane.setBackground(Color.WHITE);
        
        scrollPane1.setBounds(0, 0, 1300, 2500);
        scrollPane1.setPreferredSize(new Dimension(2500, 2500)); 
        scrollPane1.setBackground(new Color(33, 33, 33));
        
        String path = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/TV_Azteca_Cinema_logo.svg/2560px-TV_Azteca_Cinema_logo.svg.png";
                    
        try {

            JLabel label = new JLabel();
            
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            
            ImageIcon imgIcon = new ImageIcon(image);

            Image imgEscalada = imgIcon.getImage().getScaledInstance(600, 50, Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(imgEscalada);
            label.setBounds(350 , 20, 980, 100);
            label.setIcon(iconoEscalado);
            
            scrollPane1.add(label);
            
        } catch (Exception exp) {
            
            exp.printStackTrace();
            
        }
        
        
        FichaPelicula p1 = new FichaPelicula();
        
        p1.adpatarImagen("https://spoiler.bolavip.com/__export/1624372370670/sites/bolavip/img/2021/06/22/490827891_contest_1010968_standard_1623951222_crop1624369952765.jpg_72598852.jpg");
        p1.getNombrePrecio().setText("Rapidos y Furiosos 9 $10000");
        p1.getDescripcion().setText("Dom Toretto vive una vida tranquila junto a Letty y su hijo, pero el peligro siempre regresa a su vida. En esta ocasión, el equipo se enfrenta a un complot mundial orquestado por el asesino más temible del mundo: el hermano de Dom.");
        p1.getBotonAñadir().setBackground(Color.CYAN);
        
        p1.getImagen().setBounds(20, 170, 250, 300);
        p1.getNombrePrecio().setBounds(20, 140, 250, 100);
        p1.getDescripcion().setBounds(20, 460, 250, 100);
        p1.getBotonAñadir().setBounds(20, 570, 250, 30);
        
        scrollPane1.add(p1.getBotonAñadir());
        scrollPane1.add(p1.getImagen());
        scrollPane1.add(p1.getNombrePrecio());
        scrollPane1.add(p1.getDescripcion());
        
        FichaPelicula p2 = new FichaPelicula();
        
        p2.adpatarImagen("https://es.web.img3.acsta.net/pictures/21/03/30/15/41/3645913.jpg");
        p2.getNombrePrecio().setText("Escuadron suicida 2 $12000");
        p2.getDescripcion().setText("Con tal de salir de una prisión infernal, los supervillanos más peligrosos del mundo aceptan una misión del Gobierno: viajar a una remota isla, enemiga de los Estados Unidos y repleta de soldados, para destruir un laboratorio de alta tecnología.");
        p2.getBotonAñadir().setBackground(Color.CYAN);
        
        p2.getImagen().setBounds(300, 170, 250, 300);
        p2.getNombrePrecio().setBounds(300, 140, 250, 100);
        p2.getDescripcion().setBounds(300, 460, 250, 100);
        p2.getBotonAñadir().setBounds(300, 570, 250, 30);
        
        scrollPane1.add(p2.getBotonAñadir());
        scrollPane1.add(p2.getImagen());
        scrollPane1.add(p2.getNombrePrecio());
        scrollPane1.add(p2.getDescripcion());
        
        scrollPane.setViewportView(scrollPane1);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
