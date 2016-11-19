/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entidades.TipoActividad;
import entidades.HandPlantas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.GestDAO;

@ManagedBean
@SessionScoped
public class beanAct {
    @ManagedProperty ("#{gestAct}")
    GestDAO gestdao;
    
    List<HandPlantas> listCentros;
    List<TipoActividad> listaAct;
    HandPlantas centro;
    TipoActividad act;

    
    public beanAct(){
        this.inicializar();        
    }
    
    public beanAct(GestDAO gestdao, List<HandPlantas> listCentros, List<TipoActividad> listaAct, HandPlantas centro, TipoActividad act) {
        this.gestdao = gestdao;
        this.listCentros = listCentros;
        this.listaAct = listaAct;
        this.centro = centro;
        this.act = act;
    }
    
    

    public GestDAO getGestdao() {
        return gestdao;
    }

    public void setGestdao(GestDAO gestdao) {
        this.gestdao = gestdao;
    }

    public List<HandPlantas> getListCentros() {
        return listCentros;
    }

    public void setListCentros(List<HandPlantas> listCentros) {
        this.listCentros = listCentros;
    }

    public List<TipoActividad> getListaAct() {
        return listaAct;
    }

    public void setListaAct(List<TipoActividad> listaAct) {
        this.listaAct = listaAct;
    }

    public HandPlantas getCentro() {
        return centro;
    }

    public void setCentro(HandPlantas centro) {
        this.centro = centro;
    }

    public TipoActividad getAct() {
        return act;
    }

    public void setAct(TipoActividad act) {
        this.act = act;
    }
    
   
    public void inicializar(){
        
        listCentros = gestdao.listarCentros();
        listaAct = gestdao.listarActividades();
         
    }
    
}
