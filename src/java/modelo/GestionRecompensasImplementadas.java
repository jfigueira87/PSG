package modelo;

import entidades.Recompensas; 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;


@Component(value="gestion")
public class GestionRecompensasImplementadas implements GestionRecompensas{
    @PersistenceContext(name="")
    EntityManager em;
    
    @Transactional()   
    @Override
    public boolean altaRecompensas(Recompensas recom){
        em.persist(recom);
        return true;
    }
     
    public List<Recompensas> obtenerRecompensas() {
        String sql="Select r from Recompensas recom";
        Query q=em.createQuery(sql);
        return q.getResultList();
        
    }
    
    public List<Recompensas> eliminarRecompensas() {
        String sql = "DELETE FROM Retos r WHERE r.idrecompensas = :idrecompensas";
        Query q=em.createQuery(sql);
        return q.getResultList();      
    }

    @Override
    public void AltaRecompensas(Recompensas recom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}