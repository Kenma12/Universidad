/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import AccesoADatos.MateriaData;
import java.util.ArrayList;

/**
 *
 * @author Enzo-PC
 */
public class MateriaServices {
    
    private MateriaData data = new MateriaData();
    
    public void CrearMateria(String nombre, int anio, boolean estado){
        Materia materia = new Materia(nombre, anio, estado);
        data.añadirMateria(materia);
    }
    public void listarMaterias(ArrayList<Materia> materias){
        materias.addAll(data.listarMaterias());
    }

    public void eliminarMateria(int id) {
        data.eliminarMateria(id);
    }
    
    public Materia buscarMateriaXId(int id){
        Materia materia = data.buscarMateriaPorId(id);
        return materia;
    }
    
    
}
