
package modelo;


import entidades.HandPlantas;
import entidades.TipoActividad;
import java.util.List;

public interface GestDAO{
    boolean persist (Object object);
    List<TipoActividad> listarActividades();
    List<HandPlantas> listarCentros();
    
}
