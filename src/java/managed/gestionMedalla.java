package managed;

import DAO.MedallasUsu;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import entidades.MedallasusuRetos;
import entidades.Retos;


@ManagedBean (name= "gestionMedallas")
@SessionScoped
public class gestionMedalla implements Serializable{
    
   private MedallasusuRetos medallasreto;
   private List<Retos> listadoMedallas = null;
   
   @ManagedProperty("#{gestionmed}")
   MedallasUsu medallasusu;
    
    public gestionMedalla(MedallasUsu medallasusu) {
        this.medallasusu = medallasusu;
        
    }
    
    public gestionMedalla(){
        
    }

    public MedallasusuRetos getMedallasreto() {
        return medallasreto;
    }

    public void setMedallasreto(MedallasusuRetos medallasreto) {
        this.medallasreto = medallasreto;
    }

    public List<Retos> getListadoMedallas() {
        return listadoMedallas;
    }

    public void setListadoMedallas(List<Retos> listadoMedallas) {
        this.listadoMedallas = listadoMedallas;
    }

    public MedallasUsu getMedallasusu() {
        return medallasusu;
    }

    public void setMedallasusu(MedallasUsu medallasusu) {
        this.medallasusu = medallasusu;
    }
    
    public String agregarMedallasUsu(){
        medallasusu.agregarMedallasUsu(medallasreto);
       
        return "";
    }
    
    public String modificarMedallasUsu(){
        medallasusu.modificarMedallasUsu(medallasreto);
        return "";
    }

    public String eliminarMedallasUsu(){
        medallasusu.eliminarMedallasUsu(medallasreto);
        return "";
    }
    
}

