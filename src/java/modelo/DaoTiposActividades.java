/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.TipoActividad;

import java.util.List;

/**
 *
 * @author Jonnatha
 */
public interface DaoTiposActividades {
    public void guardarActividad(TipoActividad act);
    public void eliminarActividad(int idtipoActividad);
    public void modificarActividad(TipoActividad act);
    public TipoActividad obtenerActividad(int idtipoActividad);
    public List<TipoActividad> mostrarActividades();
    public List<TipoActividad> exportarActividades();
}
