/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.TipoActividad;
import entidades.HandPlantas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="gestAct")
public class GestionImpl implements GestDAO{
    @PersistenceContext(name="Psg2PU")
    EntityManager em;
    
    @Transactional()
    @Override
    public boolean persist (Object object){
        em.persist(object);
        return true;
    }
    
    
    @Override
    public List<TipoActividad> listarActividades(){
        Query q= em.createNamedQuery("Actividades.findAll");
        List<TipoActividad> listact;
        listact=q.getResultList();
        return listact;
    }
    
    @Override
    public List<HandPlantas> listarCentros(){
        Query q=em.createNamedQuery("HandPlantas.findAll");
        List<HandPlantas> listaplant;
        listaplant=q.getResultList();
        return listaplant;
    }
    
   /*public List<Actividades> mostrarActSelec(){
        Query q=em.createNamedQuery();
        List<Actividades> result=q.getResultList();
        return result;
    } */ 

   
    }
    
