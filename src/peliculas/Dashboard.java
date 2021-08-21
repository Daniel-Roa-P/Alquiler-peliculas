
package peliculas;

import Datos.DBconexion;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Dashboard extends JFrame{
    
    JLabel textoSeleccion = new JLabel("Seleccione el tipo de consulta");
    JComboBox opciones = new JComboBox();
    
    JScrollPane scrollConsultaExterno = new JScrollPane();
    JScrollPane scrollConsultaInterno = new JScrollPane();
    
    Dashboard(){
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(33, 33, 33));
        
        c.add(opciones);
        c.add(textoSeleccion);
        c.add(scrollConsultaExterno);
        
        textoSeleccion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        textoSeleccion.setForeground(Color.WHITE);
        textoSeleccion.setBounds(20, 20, 1000, 35);
        
        opciones.addItem("Peliculas Alquiladas");
        opciones.addItem("Peliculas Disponibles");
        opciones.addItem("Ultimos Alquileres");
        
        opciones.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        
        opciones.setBounds(20, 60, 770, 30);

        scrollConsultaExterno.setBounds(20, 100, 770, 570);
        
        scrollConsultaInterno.removeAll();
        
        scrollConsultaInterno.setBounds(0, 0, 2000, 6000);
        scrollConsultaInterno.setPreferredSize(new Dimension(2000, 6000)); 
        scrollConsultaInterno.setBackground(new Color(33, 33, 33));
        
        scrollConsultaExterno.setViewportView(scrollConsultaInterno);

        opciones.addActionListener((ActionEvent e) -> {
            
            switch (opciones.getSelectedIndex()) {
                case 0:                  
                    
                    consultarAlquiladas();
                    
                    break;
                case 1:

                    consultarDisponibles();
                    
                    break;
                case 2:
                        
                    consultarMovimientos();
                    
                    break;
            
                default:
                    break;
            }
                        
        });
        
    }
    
    void consultarAlquiladas(){
        
        scrollConsultaInterno.removeAll();
        
        JLabel texto2 = new JLabel("Usuario");
        JLabel texto3 = new JLabel("Pelicula");
        
        texto2.setBounds(20,10,500,40);
        texto2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto2.setForeground(Color.WHITE);
        
        texto3.setBounds(200,10,500,40);
        texto3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto3.setForeground(Color.WHITE);
        
        scrollConsultaInterno.add(texto2);
        scrollConsultaInterno.add(texto3);
        
        DBconexion con = new DBconexion();
        PreparedStatement Statement;
        
        try {

            Statement = con.getConexion().prepareStatement("SELECT * FROM tienda.usuarios");             
            ResultSet result = Statement.executeQuery();

            int y = 0;
            
            while(result.next()) {

                String cadenaPeliculas = result.getString("prestadas");
                String Usuario = result.getString("nombre");
                
                String [] peliculas = cadenaPeliculas.split(",");
                
                for(int i = 0; i < peliculas.length; i++){
                    
                    JLabel peli = new JLabel(peliculas[i]);
                    JLabel nombre = new JLabel(Usuario);
                    
                    peli.setForeground(Color.WHITE);
                    nombre.setForeground(Color.WHITE);
                    
                    nombre.setBounds(20,40 + y,500,40);
                    peli.setBounds(200,40 + y,500,40);
                    
                    scrollConsultaInterno.add(peli);
                    scrollConsultaInterno.add(nombre);
                    
                    y = y +30;
                    
                }

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        
        scrollConsultaExterno.setViewportView(scrollConsultaInterno);
        
    }
    
    void consultarDisponibles(){
        
        scrollConsultaInterno.removeAll();
        
        JLabel texto2 = new JLabel("Pelicula");
        JLabel texto3 = new JLabel("Disponibles");
        
        texto2.setBounds(20,10,500,40);
        texto2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto2.setForeground(Color.WHITE);
        
        texto3.setBounds(200,10,500,40);
        texto3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto3.setForeground(Color.WHITE);
        
        scrollConsultaInterno.add(texto2);
        scrollConsultaInterno.add(texto3);
        
        DBconexion con = new DBconexion();
        PreparedStatement Statement;
        
        try {

            Statement = con.getConexion().prepareStatement("SELECT * FROM tienda.peliculas");             
            ResultSet result = Statement.executeQuery();

            int y = 0;
            
            while(result.next()) {
                    
                JLabel peli = new JLabel(result.getString("nombre"));
                JLabel cantidad = new JLabel(String.valueOf(result.getInt("disponibles")));

                peli.setForeground(Color.WHITE);
                cantidad.setForeground(Color.WHITE);

                cantidad.setBounds(200,40 + y,500,40);
                peli.setBounds(20,40 + y,500,40);

                scrollConsultaInterno.add(peli);
                scrollConsultaInterno.add(cantidad);

                y = y +30;

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        
        scrollConsultaExterno.setViewportView(scrollConsultaInterno);
        
    }
    
    void consultarMovimientos(){
        
        scrollConsultaInterno.removeAll();
        
        JLabel texto2 = new JLabel("ID compra");
        JLabel texto3 = new JLabel("Cliente");
        JLabel texto4 = new JLabel("Cuenta");
        JLabel texto5 = new JLabel("Peliculas pedidas");
        
        texto2.setBounds(20,10,500,40);
        texto2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto2.setForeground(Color.WHITE);
        
        texto3.setBounds(200,10,500,40);
        texto3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto3.setForeground(Color.WHITE);
        
        texto4.setBounds(380,10,500,40);
        texto4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto4.setForeground(Color.WHITE);
        
        texto5.setBounds(560,10,500,40);
        texto5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto5.setForeground(Color.WHITE);
        
        scrollConsultaInterno.add(texto2);
        scrollConsultaInterno.add(texto3);
        scrollConsultaInterno.add(texto4);
        scrollConsultaInterno.add(texto5);
        
        DBconexion con = new DBconexion();
        PreparedStatement Statement;
        
        try {

            Statement = con.getConexion().prepareStatement("SELECT * FROM tienda.movimientos");             
            ResultSet result = Statement.executeQuery();

            int y = 0;
            
            while(result.next()) {
                    
                JLabel id = new JLabel(String.valueOf(result.getInt("id")));
                JLabel cliente = new JLabel(result.getString("nombre"));
                JLabel cuenta = new JLabel(String.valueOf(result.getInt("cuenta")));
                JLabel peliculas = new JLabel(result.getString("pedidas"));

                id.setForeground(Color.WHITE);
                cliente.setForeground(Color.WHITE);
                cuenta.setForeground(Color.WHITE);
                peliculas.setForeground(Color.WHITE);
                
                id.setBounds(20,40 + y,500,40);
                cliente.setBounds(200,40 + y,500,40);
                cuenta.setBounds(380,40 + y,500,40);
                peliculas.setBounds(560,40 + y,500,40);

                scrollConsultaInterno.add(id);
                scrollConsultaInterno.add(cliente);
                scrollConsultaInterno.add(cuenta);
                scrollConsultaInterno.add(peliculas);

                y = y +30;

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        
        scrollConsultaExterno.setViewportView(scrollConsultaInterno);
        
    }
    
}
