package managed;

import entidades.Recompensas;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import modelo.GestionRecompensas;

@ManagedBean (name="recompensas")
@RequestScoped
public class AltaRecompensas {
  
    @ManagedProperty("#{gestion}")
    GestionRecompensas gestion;
    
    
    public Recompensas getRecompensas(){
        Recompensas recompensas = null;
        return recompensas;
    }
    
    public GestionRecompensas getGestion() {
        return gestion;
    }

    public void setGestion(GestionRecompensas gestion) {
        this.gestion = gestion;
    }
    
    public Recompensas alta(){
        Recompensas recom = null;
        gestion.AltaRecompensas(recom);
        return recom; 
    }
}    



