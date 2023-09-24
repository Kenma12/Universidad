/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import org.mariadb.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Enzo-PC
 */
public class Conexion {
    
    public static final String URL = "jdbc:mariadb://localhost:3306/universidad";
    public static final String USUARIO = "root";
    public static final String CONTRASEÑA = "";
    private static Connection conexion;
    
    public Conexion(){}

    public static Connection getConnection(){
        
        try {
            //cargar driver
            Class.forName("org.mariadb.jdbc.Driver");
        
            //conexion a la db
            conexion = (Connection) DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
            System.out.println("Conexion a la base de datos establecida.");
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar driver." + ex.getMessage());
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar driver." + ex.getMessage());
        }
        
        return conexion;
    }
   
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos.");
                e.printStackTrace();
            }
        }
    }
    
    
}



/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_basededatos";
    private static final String USUARIO = "usuario";
    private static final String CONTRASEÑA = "contraseña";

    private Connection conexión;

    public DatabaseConnector() {
        conectar();
    }

    public Connection getConnection() {
        return conexión;
    }

    private void conectar() {
        try {
            // Cargar el controlador de la base de datos (debe hacerse solo una vez)
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establecer la conexión a la base de datos
            conexión = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Controlador de base de datos no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo establecer la conexión a la base de datos.");
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        if (conexión != null) {
            try {
                conexión.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos.");
                e.printStackTrace();
            }
        }
    }
}


*/
