/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.DaoTiposActividades;
import entidades.TipoActividad;

import java.util.List;


/**
 *
 * @author Jonnatha
 */
public class GestionTiposActividades {
    DaoTiposActividades daoAct;
    
    public TipoActividad obtenerActividad(int idtipoActividad){
        return daoAct.obtenerActividad(idtipoActividad);
    }
    
    public void guardarActividad(TipoActividad act){
       //Compruebo si ya existe la Actividad y si no existe la agrego
       if(daoAct.obtenerActividad(act.getIdtipoActividad())==null){
           daoAct.guardarActividad(act);
       }
    }
    
    public void eliminarActividad(int idtipoActividad){
        TipoActividad act=daoAct.obtenerActividad(idtipoActividad);
        if(act!=null){
            daoAct.eliminarActividad(idtipoActividad);
        }
    }
    
    public void modificarActividad(int idactividades, TipoActividad act){
       if(daoAct.obtenerActividad(act.getIdactividades())!=null){
           daoAct.modificarActividad(act);
       }
    }
    
    public List<TipoActividad> mostrarActividades(){
        
        return daoAct.mostrarActividades();
    }
    
    public List<TipoActividad> exportarActividades(){
        
    }
}
