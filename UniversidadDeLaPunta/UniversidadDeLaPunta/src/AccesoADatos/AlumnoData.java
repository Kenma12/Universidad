/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;
import entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Enzo-PC
 */
public class AlumnoData {
    
    private Connection conexion;
    
    public AlumnoData(){
        conexion = Conexion.getConnection();
    }
    
    public void añadirAlumno(Alumno alumno){
        String sql= "INSERT INTO alumno (dni, apellido, nombre, fechadNacimiento, estado)" 
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,  Date.valueOf(alumno.getFechadNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); 
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno agregado.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    public Alumno buscarAlumnoPorId(int id){
        
        
            
            
        
        
        return new Alumno();
    }
    
    
    //NO FUNCIONA
    
    public Alumno buscarAlumnoPorDni(int dni){
        String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechadNacimiento`, `estado`"
                + " FROM `alumno` WHERE dni = ?" ;
        Alumno alumno = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(dni);
                alumno.setFechadNacimiento(rs.getDate("fechadNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno buscado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return alumno;
    }
    
    public List<Alumno> listarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList();
        String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechadNacimiento`, `estado` FROM `alumno`";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechadNacimiento(rs.getDate("fechadNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
        return alumnos;
    }
    
    public void modificarAlumno(Alumno alumno){
    
        
    }
    
    public void eliminarAlumno(int id){
        String sql = "DELETE FROM `alumno` WHERE id = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int ex = ps.executeUpdate();
            if(ex == 1){
                JOptionPane.showMessageDialog(null, "Alumno eliminado.");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        
        
        
        
        
    }
    
}
