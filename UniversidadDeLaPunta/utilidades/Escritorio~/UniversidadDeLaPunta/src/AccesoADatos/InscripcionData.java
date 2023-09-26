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
    public ArrayList <Materia> Materianocursada (int idMateria){
        ArrayList<Materia>milista=new ArrayList<>();
        String sql = "Select * from materia where idMateria not in (select idMateria from inscripcion where idAlumno =?) AND materia.estado=1";
       PreparedStatement ps;
       
       
      try {
           
          MateriaData materiadata = new MateriaData();
          ps = conexion.prepareStatement(sql);
             ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
          while (rs.next()){
              Materia materia=materiadata.buscarMateriaPorId(rs.getInt(1));
              milista.add(materia);
              
          }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
        return milista;
        
        
        
    
    
    } 
    
}
