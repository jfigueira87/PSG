/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.TipoActividad;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jonnatha
 */
    @Component(value="gestion")
public class DaoTiposActividadesImpl implements DaoTiposActividades {
    @PersistenceContext (name="PSG_QuentalPU")
    EntityManager em;
    @Transactional()
    

    @Override
    public void guardarActividad(TipoActividad act){
        
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.persist(act);
        
        tx.commit();
        em.close();
    }
    
    @Override
    public void eliminarActividad(int idtipoActividad){
       /* EntityManager em=this.obtenerEntityManager();
        Actividad act=em.find(Actividad.class,idactividades);
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.remove(act);
        tx.commit();
        em.close();*/
        
        
        String jpql="delete from Actividad act where act.idactividades=?1";
       
        Query q=em.createQuery(jpql);
        q.setParameter(1,idtipoActividad);
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        q.executeUpdate();
        tx.commit();
        em.close();
       
        
    }
    
    @Override
    public void modificarActividad(TipoActividad act){
       
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.merge(act);
        tx.commit();
        em.close();
    }
    
    @Override
    public TipoActividad obtenerActividad(int idtipoActividad){
        
        TipoActividad act=em.find(TipoActividad.class, idtipoActividad);
        em.close();
        return act;
    }
    
    @Override
    public List<TipoActividad> mostrarActividades(){
        String jpql="select act from Actividad act";
        
        Query q=em.createQuery(jpql);
        List<TipoActividad> actividades=(List<TipoActividad>)q.getResultList();
        em.close();
        return actividades;
    }
    
    @Override
    public List<TipoActividad> exportarActividades(){
            
    }
    
}
