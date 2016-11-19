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

/*
Query necesaria en HandTiempos
@NamedQuery(name = "HandTiempos.calculoPuntuacionAgrupado2", query = "SELECT h, COUNT(h) 
FROM HandTiempos h WHERE h.tipoTiempo.id = :A GROUP BY h.operario")
*/

public class rMovimientosAgrupado {

    //Cálculo MOVIMIENTOS
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        //no hace falta transacción, es operación de lectura
        //em.getTransaction().begin();
    //utilizando otra query que agrupa por operario
        Query q = em.createNamedQuery("HandTiempos.calculoPuntuacionAgrupado2");
        q.setParameter("A","A");
        List<Object[]> listado = q.getResultList();
        //em.getTransaction().commit();
        
        //System.out.println(listado);
        System.out.println(listado.getClass());
        System.out.println("Tamaño listado: "+listado.size());
        System.out.println("Clase: "+listado.get(0).getClass());
        Object[] o = listado.get(0);
        System.out.println("Clases: "+o[0].getClass()+" "+o[1].getClass());
        entidades.HandTiempos usu = (entidades.HandTiempos) o[0];
        //System.out.println(usu.getOperario().getUsuIdusuario() +" "+o[1].toString());
        
        List<operarioMov> rankingMov = new ArrayList<>();
    //pasamos de LISTADO de objetos a list<operarioMov>    
        for(Object[] ob:listado){
            entidades.HandTiempos us = (entidades.HandTiempos) ob[0];
            //System.out.println(us.getOperario().getUsuIdusuario() +" "+ob[1].toString());
            operarioMov om = new operarioMov(us.getOperario().getUsuIdusuario(), Integer.parseInt(ob[1].toString()));
            rankingMov.add(om);
        }
        System.out.println("*Tamaño lista: "+rankingMov.size());
    //Ordenación por lambda     
        rankingMov.sort((operarioMov o1, operarioMov o2) ->  o2.getMovimientos()-o1.getMovimientos());
    //Mostramos resultado    
        rankingMov.stream().forEach((op) -> {
            System.out.println(op);
        });
        
        
            
    //Cerrar conexión
        em.close();
        emf.close();

    }

}
