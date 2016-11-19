
package DAO;


import java.util.List;
import persistencia.MedallasusuRetos;
import persistencia.Retos;



public interface MedallasUsu {
    List<Retos> obtenerMedallasUsu(int[] idreto, 
            java.sql.Date fechaMin,
            java.sql.Date fechaMax,
            String med,
            String valorMin,
            String valorMax,
            String puntos);
    
    
    public boolean agregarMedallasUsu(MedallasusuRetos medret);
    public boolean eliminarMedallasUsu(MedallasusuRetos medret);
    public void modificarMedallasUsu(MedallasusuRetos medret);
    
}
