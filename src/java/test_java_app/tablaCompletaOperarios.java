package test_java_app;

import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entidades.HandTiempos;
import entidades.TrUsuarios;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import entidades.TrUsuarios;

//https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

public class tablaCompletaOperarios {

    //Cálculo MOVIMIENTOS
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        //no hace falta transacción, es operación de lectura
        //em.getTransaction().begin();
        Query q = em.createNamedQuery("TrUsuarios.findAll");
        //q.setParameter("A","A");
        List listado = q.getResultList();
        
        HashMap<String,String> listadoOp = new HashMap<>();
        
        for(Object usu:listado){
            entidades.TrUsuarios tru = (entidades.TrUsuarios) usu;
            listadoOp.put(tru.getUsuIdusuario(), tru.getUrlfotoUsuario());
        }

        System.out.println(listado.getClass());
        System.out.println("tamaño: "+listado.size());
        System.out.println(listado.get(1).getClass());
        /*        
        for(int i=0; i<listado.size(); i++){
            entidades.HandTiempos t = (entidades.HandTiempos) listado.get(i);
            System.out.println(t.getOperario().getUsuIdusuario());
        }*/
        
        for(Map.Entry<String,String> x:listadoOp.entrySet()){
            System.out.println(x.toString());
        }      
        //listadoOp.get()
            
            
    //Cerrar conexión
        em.close();
        emf.close();

    }
    
}
