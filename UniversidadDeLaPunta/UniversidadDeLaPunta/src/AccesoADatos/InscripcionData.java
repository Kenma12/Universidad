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
    
  
}
