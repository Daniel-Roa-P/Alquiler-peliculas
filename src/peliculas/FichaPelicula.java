
package peliculas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import static peliculas.Peliculas.aviso;
import static peliculas.Peliculas.carrito;

public class FichaPelicula implements ActionListener {

    private JLabel imagen = new JLabel();
    private JTextArea nombrePrecio = new JTextArea("");
    private JTextArea descripcion = new JTextArea("");
    private JButton botonAñadir = new JButton("Añadir");
    private int precio, disponibles;
    private String nombre;
    
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
    
        botonAñadir.setBackground(Color.CYAN);
        botonAñadir.addActionListener(this);
        
    }
    
    //metodo que recupera una imagen apartir de una url proveniente de la base de datos
    
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // listener el cual permite añadir elementos al carrito y actualizar la informacion de este segun corresponda la pelicula elegida por el usuario
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == botonAñadir){
            
            if(disponibles>0){
            
                Articulo nuevo = new Articulo(nombre, precio);
                carrito.add(nuevo);

                int precioAcumulado = 0;

                for (int i=0; i < carrito.size(); i++){

                    precioAcumulado = carrito.get(i).getPrecioProducto() + precioAcumulado;

                }
                
                disponibles--;
                botonAñadir.setText("" + disponibles + " Disponibles - Añadir");
                aviso.setText(carrito.size() + " articulos registrados - $ " + precioAcumulado);
                
            } else {
            
                //en caso de quedarse sin unidades disponibles se inhailita el uso del boton
                botonAñadir.setEnabled(false);
                
            }
            
            
        }
    
    }
    
}
