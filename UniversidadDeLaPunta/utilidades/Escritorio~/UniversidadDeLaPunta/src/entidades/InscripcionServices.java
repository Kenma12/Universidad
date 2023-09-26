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
    public InscripcionServices(){
        
    }
    
    private InscripcionData data = new InscripcionData();
    public void crearinscripcion(int Nota ,Alumno idAlumno , Materia idMateria ){
        Inscripcion inscripcion = new Inscripcion(Nota, idAlumno, idMateria); 
    }
    public void listarInscripciones(ArrayList<Inscripcion> inscriptos){
        inscriptos.addAll(data.listarInscriptos());
    }
    
    public void listarInscripcionesXAlum(ArrayList<Inscripcion> inscriptos){
        inscriptos.addAll(data.listarInscriptosPorAlumno(0));
    }
    
}
