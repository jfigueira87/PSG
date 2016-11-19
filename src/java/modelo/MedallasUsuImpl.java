
package DAO;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import persistencia.MedallasusuRetos;
import persistencia.Retos;



@Component(value = "gestionMedallasUsu")
public class MedallasUsuImpl implements MedallasUsu {
    @PersistenceContext(name = "PSG_medallasusu")
    EntityManager em; 
    
    /*
    @Transactional()
    @Override
    public List<MedallasusuRetos> recuperarMedallas() {
        Query query = em.createNamedQuery("MedallasusuRetos.filtrado");
        List<MedallasusuRetos> lista = query.getResultList();
        return lista; 
          
    }
    */
    
    @Transactional
    @Override
    public List<Retos> obtenerMedallasUsu(int[] idreto, 
            java.sql.Date fecha_inicio, //Las fechas sobre las que hay que operar son las de la tabla "retos"
            java.sql.Date fecha_final,
            String med,
            String valorMin,
            String valorMax,
            String puntos){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PSG_medallasusu");
        EntityManager em = emf.createEntityManager();
        
        String jpql="select r from retos r join r.medallasusu_retos m join m.medallas_usuario u where ";
        jpql+="r.fecha_inicio=:fecha_inicio and r.fecha_final=:fecha_final";
        if(idreto!=null && !idreto.equals("")){
            String valores="("+idreto[0];
            for(int i=1;i<idreto.length;i++){
                valores+=","+idreto[i];
            }
            valores+=")";
            jpql+=" r.idreto in "+valores;
        }
        if(med!=null && !med.equals("")){
            jpql+=" and u.nombre='"+med+"'";
        }
        if(valorMin!=null && !valorMin.equals("")){
            jpql+=" and m.valor_min="+valorMin;
        }
        if(valorMax!=null && !valorMax.equals("")){
            jpql+=" and m.valor_max="+valorMax;
        }
        if(puntos!=null && !puntos.equals("")){
            jpql+=" and u.puntos='"+puntos+"'";
        }
        Query q=em.createQuery(jpql);
        q.setParameter("fecha_inicio", fecha_inicio, TemporalType.DATE);
        q.setParameter("fecha_final", fecha_final, TemporalType.DATE);
        List<Retos> retos=(List<Retos>)q.getResultList();
        em.close();
        emf.close();
        return retos;    
    }
    
    @Transactional
    @Override
    public boolean agregarMedallasUsu(MedallasusuRetos medret) {   
        em.persist(medret);
        return true;
    }
    
    @Transactional
    @Override
    public boolean eliminarMedallasUsu(MedallasusuRetos medret){    
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.merge(medret); 
        em.remove(medret);
        tx.commit();
        em.close();
        return true;
    }
    
    @Transactional
    @Override
    public void modificarMedallasUsu(MedallasusuRetos medret){
        em.persist(medret);
    }
}
