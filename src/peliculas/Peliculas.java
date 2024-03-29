
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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Peliculas extends JFrame implements Runnable, ActionListener {

    //Arraylist que consignara los productos seleccionados por el usuario
    
    public static ArrayList<Articulo> carrito = new ArrayList();
    public static JLabel aviso = new JLabel("0 articulos registrados - $ 0");
    
    // inicializo los elementos presentes en la interfaz
    
    JScrollPane ventanaExterna = new JScrollPane();
    JScrollPane ventanaInterna = new JScrollPane();
    
    JScrollPane scrollFichasExterno = new JScrollPane();
    JScrollPane scrollFichasInterno = new JScrollPane();
    
    JComboBox categorias = new JComboBox();
    
    JLabel textoSeleccion = new JLabel("Seleccione la categoria deseada");
    
    JButton botonComprar = new JButton("Pagar");
    JButton botonConsultar = new JButton("Dashboard");
    
    // hilo con el que se van a desplegar una a una las peliculas en la pantalla para que esta misma no se congele
    
    Thread dezpliegue;
    
    String instruccion;
    
    public static void main(String[] args) throws SQLException {
        
        //Establecer valores de la interfaz y lanzarla
        
        Peliculas catalogo = new Peliculas(); 
        catalogo.setResizable(false);
        catalogo.setBounds(0, 0, 1280, 720);
        catalogo.setTitle("Catalogo cinema");
        catalogo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        catalogo.setVisible(true);
        
    }

    Peliculas() throws SQLException{
    
        //ingreso valores en los elementos presentes en la interfaz
        
        ventanaInterna.removeAll();
        scrollFichasInterno.removeAll();
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(33, 33, 33));
        
        c.add(ventanaExterna);
        c.add(scrollFichasExterno);
        c.add(aviso);
        c.add(botonComprar);
        c.add(botonConsultar);

        botonComprar.addActionListener(this);
        botonComprar.setBounds(700, 620, 200, 60);
        botonComprar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        botonComprar.setBackground(Color.GREEN);
        
        botonConsultar.addActionListener(this);
        botonConsultar.setBounds(950, 620, 300, 60);
        botonConsultar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        botonConsultar.setBackground(Color.ORANGE);
        
        aviso.setBounds(20, 620, 1000, 60);
        aviso.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        aviso.setForeground(Color.WHITE);
        
        ventanaExterna.setBounds(0, 0, 1275, 615);
        
        ventanaInterna.setBounds(0, 0, 1250, 600);
        ventanaInterna.setPreferredSize(new Dimension(1250, 600)); 
        ventanaInterna.setBackground(new Color(33, 33, 33));
        
        ventanaInterna.add(scrollFichasExterno);
        
        scrollFichasExterno.setBounds(20, 100, 1230, 500);
        
        scrollFichasInterno.setBounds(0, 0, 10000, 500);
        scrollFichasInterno.setPreferredSize(new Dimension(6000, 450)); 
        scrollFichasInterno.setBackground(new Color(33, 33, 33));
        
        textoSeleccion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        textoSeleccion.setForeground(Color.WHITE);
        textoSeleccion.setBounds(20, 20, 1000, 35);
        
        ventanaInterna.add(textoSeleccion);
        
        categorias.addItem("Acción");
        categorias.addItem("Animada");
        categorias.addItem("Drama");
        categorias.addItem("Terror");
        categorias.addItem("Todas");
        
        categorias.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        
        categorias.setBounds(20, 60, 560, 20);
        
        ventanaInterna.add(categorias);

        //cargo el logotipo de la aplicacion
        
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
        
        //ingreso elementos en un scrollview
        
        ventanaExterna.setViewportView(ventanaInterna);
        scrollFichasExterno.setViewportView(scrollFichasInterno);
        
        //se le asigna un listener a un JComboBox con el proposito de cambiar las peliculas dezplegadas en el scrollbar segun la decision del usuario
        
        categorias.addActionListener((ActionEvent e) -> {
            
            instruccion="";
            dezpliegue = new Thread(this);
            scrollFichasInterno.removeAll(); 
            
            // segun la opcion elegida se envia una sentecia SQL para realizar una consulta segun los parametros elegidos por el usuario 
            
            switch (categorias.getSelectedIndex()) {
                case 0:
                    
                    instruccion="SELECT * FROM tienda.peliculas WHERE categoria = 'Accion'";                    
                    
                    break;
                case 1:
                    
                    instruccion="SELECT * FROM tienda.peliculas WHERE categoria = 'Animada'";                            
                    
                    break;
                case 2:
                    
                    instruccion="SELECT * FROM tienda.peliculas WHERE categoria = 'Drama'";
                        
                    break;
                case 3:

                    instruccion="SELECT * FROM tienda.peliculas WHERE categoria = 'Terror'";
                    
                    break;
                case 4:
                        
                    instruccion="SELECT * FROM tienda.peliculas";
                    
                    break;
            
                default:
                    break;
            }
             
            dezpliegue.start();
                        
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == botonComprar && !carrito.isEmpty()){
            
            //abre la ventana para la confirmacion de alquiler si el carrito no se encuentra vacio
            
            VentanaCompra compra = new VentanaCompra();
            compra.setResizable(false);
            compra.setBounds(0, 0, 420, 720);
            compra.setTitle("Comprar articulos");

            compra.setVisible(true);
            
        } else if (ae.getSource() == botonConsultar){
            
            //abre el dashboard con el cual se podra consultar la informacion alojada en las bases de datos
            
            Dashboard db = new Dashboard();
            db.setResizable(false);
            db.setBounds(0, 0, 900, 720);
            db.setTitle("Comprar articulos");

            db.setVisible(true);
            
        }
        
    }

    //hilo que muestra las peliculas una por una mientras las imagenes de estas cargan se evita que la interfaz se congele
    
    @Override
    public void run() {
        
        try{
            
            try {
        
                // segun la instruccion elegida por el usuario se lleva el scrollbar con la categoria deseada
                
                DBconexion con = new DBconexion();

                PreparedStatement Statement = con.getConexion().prepareStatement(instruccion);
                ResultSet result = Statement.executeQuery();

                int x = 20;
                categorias.setEnabled(false); // se bloquea la edicion del JComboBox para evitar errores graficos
                
                while(result.next()) {
                    
                    // se ingresan los valores internos de los obtetos FichaPelicula
                    
                    FichaPelicula fp = new FichaPelicula();

                    fp.setPrecio(result.getInt("precio"));
                    fp.setNombre(result.getString("nombre") );
                    
                    fp.getNombrePrecio().setText(result.getString("nombre") + "\n$" + result.getInt("precio"));
                    fp.getDescripcion().setText(result.getString("descripcion"));
                    fp.adpatarImagen(result.getString("urlImagen"));
                    
                    int cantidadActual = result.getInt("disponibles");
                    
                    // ciclo for el cual mantiene actualizadas la cantidad de peliculas desponibles en caso de que se recarge el srollview
                    
                    for(int i = 0; i< carrito.size(); i++){
                        
                        if(carrito.get(i).getNombreProducto().equals(result.getString("nombre"))){
                            
                            cantidadActual--;
                            
                        }
                        
                    }
                    
                    fp.setDisponibles(cantidadActual);
                    fp.getBotonAñadir().setText("" + cantidadActual + " Disponibles - Añadir");
                    
                    fp.getNombrePrecio().setBounds(x, 20, 250, 100);
                    fp.getImagen().setBounds(x, 50, 250, 300);
                    fp.getDescripcion().setBounds(x, 340, 250, 100);
                    fp.getBotonAñadir().setBounds(x, 445, 250, 30);

                    scrollFichasInterno.add(fp.getBotonAñadir());
                    scrollFichasInterno.add(fp.getImagen());
                    scrollFichasInterno.add(fp.getNombrePrecio());
                    scrollFichasInterno.add(fp.getDescripcion());

                    x = x + 280;

                    scrollFichasExterno.setViewportView(scrollFichasInterno);
   
                }
                
                categorias.setEnabled(true);
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
        }catch(Exception e){
            
        } 
    
    }
    
}
