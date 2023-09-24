/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enzo-PC
 */
public class Alumno {
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechadNac;
    private boolean activo;
    private ArrayList<Alumno> alumnos;
    //constructor vacio
    
    public Alumno(){}
    
    //constructor con id
    
    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechadNacimiento, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechadNac = fechadNacimiento;
        this.activo = activo;
    }
    
    //constructor sin id
    
    public Alumno(int dni, String apellido, String nombre, LocalDate fechadNacimiento, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechadNac = fechadNacimiento;
        this.activo = activo;
        this.alumnos = new ArrayList();
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechadNacimiento() {
        return fechadNac;
    }

    public void setFechadNacimiento(LocalDate fechadNacimiento) {
        this.fechadNac = fechadNacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void añadirALista(Alumno alumno){
        alumnos.add(alumno);
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
