/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import AccesoADatos.AlumnoData;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Enzo-PC
 */
public class AlumnoServices {
    public AlumnoServices(){}
    private AlumnoData data = new AlumnoData();
    
    public void CrearAlumno(String nombre, String apellido, int dni, LocalDate fechadNacimiento, boolean estado){
        Alumno alumno = new Alumno(dni, apellido, nombre, fechadNacimiento, estado);
        data.añadirAlumno(alumno);
    }
    
    public void listarAlumnos(ArrayList<Alumno> alumnos){
        alumnos.addAll(data.listarAlumnos());
    }
    
    public Alumno buscarAlumno(int dni){
        Alumno alum = data.buscarAlumnoPorDni(dni);
        return alum;
    }
    
    public void eliminarAlumno(int id){
        data.eliminarAlumno(id);
    }
    
    
    
    
    
}
