package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconexion {
    
    static String bd = "tienda";
    static String login = "root";
    static String password = "contraseñaMYSQL@";
    static String url = "jdbc:mysql://localhost:3306/"+bd;
    static String mensaje = "";
    
    Connection conexion = null;
    
    public DBconexion() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,login,password);

            if (conexion!=null){
                    
                System.out.println("Conexión a base de datos "+bd+" OK");
            
            }
            
        }catch(SQLException e){
                mensaje = e.getMessage();
        }catch(ClassNotFoundException e){
                mensaje = e.getMessage();
        }
        
        System.out.println(mensaje);
        
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        DBconexion.mensaje = mensaje;
    }

    public void desconectar(){
        conexion = null;
    }
    
}
