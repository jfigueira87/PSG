/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entidades.TipoActividad;
import entidades.HandPlantas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import modelo.GestDAO;
import modelo.GestionImpl;

/**
 *
 * @author Isidro
 */
@ManagedBean
@SessionScoped
public class beanActividades{
    private String c_sel;
    private String a_sel;

   @ManagedProperty("#{gact}")
   private GestDAO gestion;
   private List<HandPlantas> listacentros;
   HandPlantas centro;
   private List<TipoActividad> listaact;
   
   public beanActividades(){}

    public beanActividades(List<HandPlantas> listacentros) {
        this.listacentros = gestion.listarCentros();
    }

   
    public String listarCentros(HandPlantas centro){
        listacentros = gestion.listarCentros();
       
        return centro.getPltCc();
    }

    public List<HandPlantas> getListacentros() {
        return listacentros;
    }

    public void setListacentros(List<HandPlantas> listacentros) {
        this.listacentros = listacentros;
    }

    public List<TipoActividad> getListaact() {
        return listaact;
    }

    public void setListaact(List<TipoActividad> listaact) {
        this.listaact = listaact;
    }
    
    public GestDAO getGestion() {
        return gestion;
    }

    public void setGestion(GestDAO gestion) {
        this.gestion = gestion;
    }
   
   public List<HandPlantas> mostrarCent(){
       return gestion.listarCentros();
   }

    public String getC_sel() {
        return c_sel;
    }

    public void setC_sel(String c_sel) {
        this.c_sel = c_sel;
    }

    public String getA_sel() {
        return a_sel;
    }

    public void setA_sel(String a_sel) {
        this.a_sel = a_sel;
    }
   
   
    }
    
    


