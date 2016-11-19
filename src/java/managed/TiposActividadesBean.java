/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import dao.DaoTiposActividades;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Jonnatha
 */
@Named(value = "tiposActividadesBean")
@Dependent
public class TiposActividadesBean {
    private String centro;
    private String tipoActividad;
    private int nivMinimo;
    private int nivMaximo;
    private Date fecInicio;
    
    /**
     * Creates a new instance of TiposActividadesBean
     */
    private Actividad actividad;
    @ManagedProperty ("#{gestion}")
    DaoTiposActividades tactividades;
    
    
    public TiposActividadesBean() {
    }

    public TiposActividadesBean(Actividad actividad, DaoTiposActividades tactividades) {
        this.actividad = actividad;
        this.tactividades = tactividades;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public DaoTiposActividades getTactividades() {
        return tactividades;
    }

    public void setTactividades(DaoTiposActividades tactividades) {
        this.tactividades = tactividades;
    }
    
    public String guardarActividad(){
        tactividades.guardarActividad(actividad);
        return "";
    }
    
    public String eliminarActividad(){
        tactividades.eliminarActividad(0);
        return "";
    }
}
