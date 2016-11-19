
package modelo;
import entidades.TrUsuarios;
import javax.persistence.metamodel.SingularAttribute;


public interface GestionUsuario {
    boolean beanLogin(TrUsuarios log);
    TrUsuarios validarUsuario(String usuIdusuario ,String usuClaveacceso);

    
    
}
