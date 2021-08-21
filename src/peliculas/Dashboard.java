
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
        opciones.addItem("Peliculas Disponobles");
        opciones.addItem("Ultimos Alquileres");
        
        opciones.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        
        opciones.setBounds(20, 60, 370, 30);

        scrollConsultaExterno.setBounds(20, 100, 370, 570);
        
        scrollConsultaInterno.removeAll();
        
        scrollConsultaInterno.setBounds(0, 0, 10000, 500);
        scrollConsultaInterno.setPreferredSize(new Dimension(350, 2000)); 
        scrollConsultaInterno.setBackground(new Color(33, 33, 33));
        
        scrollConsultaExterno.setViewportView(scrollConsultaInterno);

        opciones.addActionListener((ActionEvent e) -> {
            
            switch (opciones.getSelectedIndex()) {
                case 0:                  
                    
                    consultarAlquiladas();
                    
                    break;
                case 1:

                    break;
                case 2:
                        
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
    
}
