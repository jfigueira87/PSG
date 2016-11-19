/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

//https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

public class Test_java_app {

    //Cálculo MOVIMIENTOS
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        //no hace falta transacción, es operación de lectura
        //em.getTransaction().begin();
        Query q = em.createNamedQuery("HandTiempos.calculoPuntuacion");
        q.setParameter("A","A");
        List listado = q.getResultList();
        //em.getTransaction().commit();
        
        //System.out.println(listado);
        System.out.println(listado.getClass());
        System.out.println("tamaño: "+listado.size());
        System.out.println(listado.get(1).getClass());
        /*        
        for(int i=0; i<listado.size(); i++){
            entidades.HandTiempos t = (entidades.HandTiempos) listado.get(i);
            System.out.println(t.getOperario().getUsuIdusuario());
        }*/
        
        List<operarioMov> rankingMov = new ArrayList<>();
        HashMap<String,Integer> rankMov = new HashMap<>();
        
        for(int i=0; i<listado.size(); i++){
            entidades.HandTiempos t = (entidades.HandTiempos) listado.get(i);
            String idOpe = t.getOperario().getUsuIdusuario();
            if(rankMov.containsKey(idOpe)){
                rankMov.replace(idOpe, rankMov.get(idOpe)+1);
            }else{
                rankMov.put(idOpe, 1);
            }
        }
        System.out.println("tamaño hashmap: "+rankMov.size());
        for(Map.Entry<String,Integer> x:rankMov.entrySet()){
            operarioMov op = new operarioMov(x.getKey(), x.getValue());
            rankingMov.add(op);
        } 
        System.out.println("tamaño list: "+rankingMov.size());
        //ordenación lista
        rankingMov.sort((operarioMov o1, operarioMov o2) ->  o2.getMovimientos()-o1.getMovimientos());
        
        rankingMov.stream().forEach((o) -> {
            System.out.println(o);
        });
            
            
    //Cerrar conexión
        em.close();
        emf.close();

    }
    
}
/*
        List<String> listaOp = null;
        HashMap<String,Integer> rankMov = new HashMap<>();
        
        for(int i=0; i<listado.size(); i++){
            entidades.HandTiempos t = (entidades.HandTiempos) listado.get(i);
            String idOpe = t.getOperario().getUsuIdusuario();
            if(rankMov.containsKey(idOpe)){
                rankMov.replace(idOpe, rankMov.get(idOpe)+1);
            }else{
                rankMov.put(idOpe, 1);
            }
        }
        System.out.println(rankMov.size());
        for(Map.Entry<String,Integer> x:rankMov.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue());
        }*/