package modelo;


import entidades.Retos;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eva
 */
public interface GestionRetos {
    boolean altaRetos(Retos r);
    List<Retos> obtenerRetos();
    void eliminarReto();
    void modificarReto(Retos r);    
    
}
