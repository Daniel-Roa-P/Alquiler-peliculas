
package peliculas;

import Datos.DBconexion;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static peliculas.Peliculas.aviso;
import static peliculas.Peliculas.carrito;

public class VentanaCompra extends JFrame implements ActionListener {

    JLabel texto = new JLabel("Articulos a comprar");
    JLabel cuenta = new JLabel("Total a pagar: ");
    JLabel textoUsuario = new JLabel("Ingrese su usuario (Nombre)");
    JLabel textoCrear = new JLabel("¿Sin usario? creelo ahora mismo");
    
    JTextField usuario = new JTextField("Daniel");
    JTextField nuevoUsuario = new JTextField();
    
    JScrollPane scrollListaExterno = new JScrollPane();
    JScrollPane scrollListaInterno = new JScrollPane();
    
    JButton botonPagar = new JButton("Pagar");
    JButton botonRegistrar = new JButton("Registrar y pagar");
    
    int factura = 0;
    String nuevasPelis = "";
    
    VentanaCompra(){
    
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(new Color(33, 33, 33));
        
        c.add(scrollListaExterno);
        c.add(texto);
        c.add(cuenta);
        c.add(texto);
        c.add(textoUsuario);
        c.add(textoCrear);
        c.add(usuario);
        c.add(nuevoUsuario);
        c.add(botonPagar);
        c.add(botonRegistrar);
        
        texto.setBounds(20,10,500,40);
        texto.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        texto.setForeground(Color.WHITE);
        
        cuenta.setBounds(20,500,500,30);
        cuenta.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        cuenta.setForeground(Color.WHITE);
        
        textoUsuario.setBounds(20,530,370,20);
        textoCrear.setBounds(20,610,370,20);
        textoUsuario.setForeground(Color.WHITE);
        textoCrear.setForeground(Color.WHITE);
        
        usuario.setBounds(20,550,370,20);
        nuevoUsuario.setBounds(20,630,370,20);
        
        botonPagar.addActionListener(this);
        botonPagar.setBounds(20,580,370,20);
        botonPagar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        botonPagar.setBackground(Color.green);
        
        botonRegistrar.addActionListener(this);
        botonRegistrar.setBounds(20,660,370,20);
        botonRegistrar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        botonRegistrar.setBackground(Color.CYAN);
        
        scrollListaExterno.setBounds(20, 50, 370, 450);
        
        scrollListaInterno.removeAll();
        
        scrollListaInterno.setBounds(0, 0, 10000, 500);
        scrollListaInterno.setPreferredSize(new Dimension(350, 2000)); 
        scrollListaInterno.setBackground(new Color(33, 33, 33));
        
        llenarListado();
        
    }
    
    void llenarListado(){
        
        scrollListaInterno.removeAll();
        
        JLabel texto2 = new JLabel("Pelicula");
        JLabel texto3 = new JLabel("Precio");
        
        texto2.setBounds(20,10,500,40);
        texto2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto2.setForeground(Color.WHITE);
        
        texto3.setBounds(200,10,500,40);
        texto3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        texto3.setForeground(Color.WHITE);
        
        scrollListaInterno.add(texto2);
        scrollListaInterno.add(texto3);
        
        for(int i = 0; i < carrito.size(); i++){
        
            ElementoLista e = new ElementoLista(carrito.get(i).getNombreProducto(),carrito.get(i).getPrecioProducto(), i*30);
            
            scrollListaInterno.add(e.nombre);
            scrollListaInterno.add(e.precio);
            scrollListaInterno.add(e.botonComprar);
            
            nuevasPelis = nuevasPelis + "," + e.nombre.getText();
            
            factura = factura + carrito.get(i).getPrecioProducto();
            
        }
        
        cuenta.setText("Total a pagar: " + factura);
        aviso.setText(carrito.size() + " articulos registrados - $ " + factura);
        
        scrollListaExterno.setViewportView(scrollListaInterno);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == botonPagar && usuario.getText().length()!= 0){
            
            String id = usuario.getText();
            
            actualizarUsuario(id);
            actualizarPeliculas();
            
            carrito = new ArrayList();
            
            dispose();
            
        } else if (ae.getSource() == botonRegistrar && nuevoUsuario.getText().length()!= 0){
            
            VentanaCompra compra = new VentanaCompra();
            compra.setResizable(false);
            compra.setBounds(0, 0, 420, 720);
            compra.setTitle("Comprar articulos");

            compra.setVisible(true);
            
        }
        
    }
    
    public void actualizarUsuario(String id){
        
        DBconexion con = new DBconexion();
        PreparedStatement Statement;

        try {

            Statement = con.getConexion().prepareStatement("SELECT * FROM tienda.usuarios WHERE nombre = '" + id + "'");             
            ResultSet result = Statement.executeQuery();

            int deudaPasada = 0;
            String peliculasAlquiladas = "";

            while(result.next()) {

                deudaPasada = result.getInt("deuda");
                peliculasAlquiladas = result.getString("prestadas");

            }

            PreparedStatement pstm = con.getConexion().prepareStatement("update usuarios set deuda = ?, "
                + " prestadas = ?"
                + " where nombre = ?");

            pstm.setInt(1, deudaPasada + factura);
            pstm.setString(2, peliculasAlquiladas+nuevasPelis);
            pstm.setString(3, id);

            pstm.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        con.desconectar();
        
    }
    
    public void actualizarPeliculas(){
        
        DBconexion con = new DBconexion();
        PreparedStatement Statement;

        try {

            for(int i = 0; i < carrito.size(); i++){
             
                Statement = con.getConexion().prepareStatement("SELECT * FROM tienda.peliculas WHERE nombre = '" + carrito.get(i).getNombreProducto() + "'");             
                ResultSet result = Statement.executeQuery();

                int cantidad = 0;
                
                while(result.next()) {

                    cantidad = result.getInt("disponibles");

                }

                PreparedStatement pstm = con.getConexion().prepareStatement("update peliculas set disponibles = ? "
                    + " where nombre = ?");

                pstm.setInt(1, cantidad - 1);
                pstm.setString(2, carrito.get(i).getNombreProducto());

                pstm.executeUpdate();
                
                
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        con.desconectar();
        
    }

    class ElementoLista implements ActionListener {

        JLabel nombre, precio;
        JButton botonComprar = new JButton("X");
        
        ElementoLista(String nombre, int precio, int y){
        
            this.nombre = new JLabel(nombre);
            this.precio = new JLabel(String.valueOf(precio));
            
            this.nombre.setBounds(20,40 + y,500,40);
            this.precio.setBounds(200,40 + y,500,40);
            
            this.nombre.setForeground(Color.WHITE);
            this.precio.setForeground(Color.WHITE);
            botonComprar.setForeground(Color.WHITE);
            
            botonComprar.setBackground(Color.RED);
            botonComprar.setBounds(270,50 + y,45,20);
            
            botonComprar.addActionListener(this);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource()== botonComprar){
            
                System.out.println(nombre.getText());
                
                int x = 0;
                
                while(true){
                    
                    if(carrito.get(x).getNombreProducto().equals(nombre.getText())){
                        
                        carrito.remove(carrito.get(x));
                        break;
                    }
                    
                    x++;
                    
                }
                
            }
            
            llenarListado();
            
        }
 
    }
    
}
