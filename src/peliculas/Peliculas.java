
package peliculas;

import Datos.DBconexion;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Peliculas extends JFrame implements ActionListener {

    JScrollPane ventanaExterna = new JScrollPane();
    JScrollPane ventanaInterna = new JScrollPane();
    
    JScrollPane scrollFichasExterno = new JScrollPane();
    JScrollPane scrollFichasInterno = new JScrollPane();
    
    JComboBox categorias = new JComboBox();
    
    JLabel textoSeleccion = new JLabel("Seleccione la categoria deseada");
    
    public static void main(String[] args) throws SQLException {
        
        Peliculas catalogo = new Peliculas(); 
        catalogo.setResizable(false);
        catalogo.setBounds(0, 0, 1280, 720);
        catalogo.setTitle("Catalogo cinema");
        catalogo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        catalogo.setVisible(true);
        
    }

    Peliculas() throws SQLException{
    
        ventanaInterna.removeAll();
        scrollFichasInterno.removeAll();
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(33, 33, 33));
        
        c.add(ventanaExterna);
        c.add(scrollFichasExterno);

        ventanaExterna.setBounds(0, 0, 1275, 615);
        ventanaExterna.setBackground(Color.WHITE);
        
        ventanaInterna.setBounds(0, 0, 1250, 600);
        ventanaInterna.setPreferredSize(new Dimension(1250, 600)); 
        ventanaInterna.setBackground(new Color(33, 33, 33));
        
        ventanaInterna.add(scrollFichasExterno);
        
        scrollFichasExterno.setBounds(20, 100, 1230, 500);
        scrollFichasExterno.setBackground(Color.WHITE);
        
        scrollFichasInterno.setBounds(0, 0, 1250, 500);
        scrollFichasInterno.setPreferredSize(new Dimension(1300, 450)); 
        scrollFichasInterno.setBackground(new Color(33, 33, 33));
        
        textoSeleccion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        textoSeleccion.setForeground(Color.WHITE);
        textoSeleccion.setBounds(20, 20, 1000, 35);
        
        ventanaInterna.add(textoSeleccion);
        
        categorias.addItem("Acción");
        categorias.addItem("Terror");
        categorias.addItem("Comedia");
        categorias.addItem("Romantico");
        categorias.addItem("Animada");
        
        categorias.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        
        categorias.setBounds(20, 60, 560, 20);
        
        ventanaInterna.add(categorias);

        String path = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/TV_Azteca_Cinema_logo.svg/2560px-TV_Azteca_Cinema_logo.svg.png";
                    
        try {

            JLabel label = new JLabel();
            
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            
            ImageIcon imgIcon = new ImageIcon(image);

            Image imgEscalada = imgIcon.getImage().getScaledInstance(600, 70, Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(imgEscalada);
            label.setBounds(650 , 20, 600, 70);
            label.setIcon(iconoEscalado);
            
            ventanaInterna.add(label);
            
        } catch (Exception exp) {
            
            exp.printStackTrace();
            
        }
        
        DBconexion con = new DBconexion();
        
        PreparedStatement Statement = con.getConexion().prepareStatement("Select * from peliculas");
        ResultSet result = Statement.executeQuery();
        
        int x = 20;
        
        while(result.next()) {

            FichaPelicula p1 = new FichaPelicula();
            
            p1.getNombrePrecio().setText(result.getString("nombre"));
            p1.getDescripcion().setText(result.getString("descripcion"));
            p1.adpatarImagen(result.getString("urlImagen"));
            
            p1.getBotonAñadir().setBackground(Color.CYAN);
        
            p1.getNombrePrecio().setBounds(x, 20, 250, 100);
            p1.getImagen().setBounds(x, 50, 250, 300);
            p1.getDescripcion().setBounds(x, 340, 250, 100);
            p1.getBotonAñadir().setBounds(x, 445, 250, 30);

            scrollFichasInterno.add(p1.getBotonAñadir());
            scrollFichasInterno.add(p1.getImagen());
            scrollFichasInterno.add(p1.getNombrePrecio());
            scrollFichasInterno.add(p1.getDescripcion());
            
            x = x + 280;
            
        }
        
//        p1.adpatarImagen("https://spoiler.bolavip.com/__export/1624372370670/sites/bolavip/img/2021/06/22/490827891_contest_1010968_standard_1623951222_crop1624369952765.jpg_72598852.jpg");
//        p1.getNombrePrecio().setText("Rapidos y Furiosos 9 $10000");
//        p1.getDescripcion().setText("Dom Toretto vive una vida tranquila junto a Letty y su hijo, pero el peligro siempre regresa a su vida. En esta ocasión, el equipo se enfrenta a un complot mundial orquestado por el asesino más temible del mundo: el hermano de Dom.");
        
//        FichaPelicula p2 = new FichaPelicula();
//        
//        p2.adpatarImagen("https://es.web.img3.acsta.net/pictures/21/03/30/15/41/3645913.jpg");
//        p2.getNombrePrecio().setText("Escuadron suicida 2 $12000");
//        p2.getDescripcion().setText("Con tal de salir de una prisión infernal, los supervillanos más peligrosos del mundo aceptan una misión del Gobierno: viajar a una remota isla, enemiga de los Estados Unidos y repleta de soldados, para destruir un laboratorio de alta tecnología.");
//        p2.getBotonAñadir().setBackground(Color.CYAN);
//        
//        p2.getNombrePrecio().setBounds(300, 20, 250, 100);
//        p2.getImagen().setBounds(300, 50, 250, 300);
//        p2.getDescripcion().setBounds(300, 340, 250, 100);
//        p2.getBotonAñadir().setBounds(300, 445, 250, 30);
//        
//        scrollFichasInterno.add(p2.getBotonAñadir());
//        scrollFichasInterno.add(p2.getImagen());
//        scrollFichasInterno.add(p2.getNombrePrecio());
//        scrollFichasInterno.add(p2.getDescripcion());
        
//        p1 = new FichaPelicula();
//        
//        p1.adpatarImagen("https://es.web.img3.acsta.net/pictures/21/03/30/15/41/3645913.jpg");
//        p1.getNombrePrecio().setText("Escuadron suicida 2 $12000");
//        p1.getDescripcion().setText("Con tal de salir de una prisión infernal, los supervillanos más peligrosos del mundo aceptan una misión del Gobierno: viajar a una remota isla, enemiga de los Estados Unidos y repleta de soldados, para destruir un laboratorio de alta tecnología.");
//        p1.getBotonAñadir().setBackground(Color.CYAN);
//        
//        p1.getNombrePrecio().setBounds(300, 20, 250, 100);
//        p1.getImagen().setBounds(300, 50, 250, 300);
//        p1.getDescripcion().setBounds(300, 340, 250, 100);
//        p1.getBotonAñadir().setBounds(300, 445, 250, 30);
//        
//        scrollFichasInterno.add(p1.getBotonAñadir());
//        scrollFichasInterno.add(p1.getImagen());
//        scrollFichasInterno.add(p1.getNombrePrecio());
//        scrollFichasInterno.add(p1.getDescripcion());

        ventanaExterna.setViewportView(ventanaInterna);
        scrollFichasExterno.setViewportView(scrollFichasInterno);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
