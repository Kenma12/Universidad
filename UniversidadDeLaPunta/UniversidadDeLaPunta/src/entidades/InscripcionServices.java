/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import AccesoADatos.InscripcionData;
import java.util.ArrayList;

/**
 *
 * @author Enzo-PC
 */
public class InscripcionServices {
    
    private InscripcionData data = new InscripcionData();
    
    public void listarInscripciones(ArrayList<Inscripcion> inscriptos){
        inscriptos.addAll(data.listarInscriptos());
    }
    
    public void listarInscripcionesXAlum(ArrayList<Inscripcion> inscriptos){
        inscriptos.addAll(data.listarInscriptosPorAlumno(0));
    }
    public void inscripcionAmateria(int nota, Alumno alumno, Materia materia){
        Inscripcion inc = new Inscripcion(nota, alumno, materia); 
        data.añadirIncriptoAMateria(inc);
    }
}
