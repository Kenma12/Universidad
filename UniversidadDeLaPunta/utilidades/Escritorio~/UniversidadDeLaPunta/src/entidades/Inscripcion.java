/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Enzo-PC
 */
public class Inscripcion {
    
    private int idIncripcion;
    private int nota;
    private Alumno alumno;
    private Materia materia;

    //constructor vacio
    
    public Inscripcion() {
    }

    //constructor sin 'idInscription'
    
    public Inscripcion(int idIncripcion ,int nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
        this.idIncripcion = idIncripcion;
    }

    ////constructor con 'idInscription'
    
    public Inscripcion(int nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getIdIncripcion() {
        return idIncripcion;
    }

    public void setIdIncripcion(int idIncripcion) {
        this.idIncripcion = idIncripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        String insc = idIncripcion + " " + alumno.getApellido() + ", " + alumno.getNombre() + ", " + materia.getNombre();
        return insc;
    }
    
    
    
    
    
    
    
    
}
