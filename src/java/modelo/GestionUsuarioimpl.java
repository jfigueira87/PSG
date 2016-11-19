
package modelo;

import beans.TrUsuarios;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.stereotype.Component;

@Component (value="gestion")
public class GestionUsuarioimpl implements GestionUsuario{
    @PersistenceContext(name = "Psg2PU")
    EntityManager em;
    
    @Override
    public boolean beanLogin(TrUsuarios usu){
        em.persist(usu);
        return true;   
    }
    @Override
    public TrUsuarios validarUsuario(String usuIdusuario ,String usuClaveacceso){
        
        Query q=em.createNamedQuery("TrUsuarios.login");
        q.setParameter("usuIdusuario",usuIdusuario);
        q.setParameter("usuClaveacceso",usuClaveacceso);
        TrUsuarios result=(TrUsuarios) q.getSingleResult();
        return result;
      
    }
    
}
