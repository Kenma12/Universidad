/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
/**
 *
 * @author Enzo-PC
 */
public class InscripcionData {
    private Connection conexion;
    private MateriaData md= new MateriaData();
    private AlumnoData ad = new AlumnoData();
    
    public InscripcionData(){
        conexion = Conexion.getConnection();
    }
    
    public List<Inscripcion> listarInscriptos(){
            String sql = "SELECT `idInscripto`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion`";
            ArrayList<Inscripcion> inscs = new ArrayList();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setIdIncripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getInt("nota"));
                Alumno alu = ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateriaPorId(rs.getInt("idMateria"));
                insc.setMateria(mat);
                insc.setAlumno(alu);
                inscs.add(insc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return inscs;
    }
    
    public List<Inscripcion> listarInscriptosPorAlumno(int idAlumno){
            ArrayList<Inscripcion> cursadas = new ArrayList<>();
            String sql = "SELECT `idInscripto`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion`"
                    + " WHERE idAlumno = ?";
            
        try { 
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setIdIncripcion(rs.getInt("idInscripto"));
                Alumno alum = ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateriaPorId(rs.getInt("idMateria"));
                insc.setAlumno(alum);
                insc.setMateria(mat);
                insc.setNota(rs.getInt("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return cursadas;
        
    }
    public ArrayList<Materia> materiaNoCursada(int idAlumno){
       ArrayList<Materia>miLista=new ArrayList<>();
       String sql = "Select * from materia where idMateria not in (select idMateria from inscripcion where idAlumno =?) AND materia.estado=1";
       PreparedStatement ps;
       
       try {
            
          MateriaData materiadata = new MateriaData();
          ps = conexion.prepareStatement(sql);
          ps.setInt(1, idAlumno);
          ResultSet rs = ps.executeQuery();
          while (rs.next()){
              Materia materia=materiadata.buscarMateriaPorId(rs.getInt(1));
              miLista.add(materia);    
          }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);  
        }
         
        return miLista;
        
    } ///tratando de ahcer el agregado de la inscripcion 
    public void añadirIncriptoAMateria(Inscripcion inscrip){
        String sql= "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscrip.getNota());
            ps.setInt(2, inscrip.getAlumno().getIdAlumno());
            ps.setInt(3, inscrip.getMateria().getIdMateria());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys(); 
            if(rs.next()){
                inscrip.setIdIncripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno inscripto.");
            }
            rs.close();
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: ." + ex.getMessage());
        }
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int filas = ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Inscripcion borrada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void actualizarNota(int idAlumno, int nota){
        String sql = "UPDATE `inscripcion` SET `nota`= ? WHERE idAlumno = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            int fila = ps.executeUpdate();
            if(fila>0){
               JOptionPane.showMessageDialog(null, "Notas actualizadas.");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());            
        }
    }
}
