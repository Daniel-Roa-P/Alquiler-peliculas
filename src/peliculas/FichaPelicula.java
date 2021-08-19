
package peliculas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FichaPelicula {

    private JLabel imagen = new JLabel();
    private JTextArea nombrePrecio = new JTextArea("");
    private JTextArea descripcion = new JTextArea("");
    private JButton botonAñadir = new JButton("Añadir");
    
    FichaPelicula(){
    
        nombrePrecio.setWrapStyleWord(true);
        nombrePrecio.setLineWrap(true);
        nombrePrecio.setEditable(false);
        nombrePrecio.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        nombrePrecio.setForeground(Color.WHITE);
        nombrePrecio.setBackground(Color.black);
        
        descripcion.setWrapStyleWord(true);
        descripcion.setLineWrap(true);
        descripcion.setEditable(false);
        descripcion.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        descripcion.setForeground(Color.WHITE);
        descripcion.setBackground(Color.black);
    
    }
    
    public void adpatarImagen(String path){
    
    try {
            
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            
            ImageIcon imgIcon = new ImageIcon(image);

            Image imgEscalada = imgIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(imgEscalada);
            imagen.setIcon(iconoEscalado);
            
        } catch (Exception exp) {
            
            exp.printStackTrace();
            
        }
        
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JTextArea getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JTextArea descripcion) {
        this.descripcion = descripcion;
    }

    public JButton getBotonAñadir() {
        return botonAñadir;
    }

    public void setBotonAñadir(JButton botonAñadir) {
        this.botonAñadir = botonAñadir;
    }

    public JTextArea getNombrePrecio() {
        return nombrePrecio;
    }
    
}
