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
import entidades.HandHrealOper;

/*Query:
    @NamedQuery(name = "HandHrealOper.calculoCompromiso", query = "SELECT h 
    FROM HandHrealOper h WHERE (h.trabajado = '0' AND h.motivoId.id >2)"),
*/

public class rCompromiso {

    //Cálculo MOVIMIENTOS
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        //no hace falta transacción, es operación de lectura
        //em.getTransaction().begin();
        Query q = em.createNamedQuery("HandHrealOper.calculoCompromiso");

        List listado = q.getResultList();
        //em.getTransaction().commit();
        
        //System.out.println(listado);
        System.out.println(listado.getClass());
        System.out.println("tamaño: "+listado.size());
        System.out.println(listado.get(1).getClass());
        
        HashMap<String,Integer> aux = new HashMap<>();
        for(int i=0; i<listado.size(); i++){
            entidades.HandHrealOper ope = (entidades.HandHrealOper) listado.get(i);
            if(aux.containsKey(ope.getTrUsuarios().getUsuIdusuario())){
                aux.replace(ope.getTrUsuarios().getUsuIdusuario(), 
                    aux.get(ope.getTrUsuarios().getUsuIdusuario())+1);
            }else{
                aux.put(ope.getTrUsuarios().getUsuIdusuario(), 1);
            }
        }
        System.out.println("Tamaño aux: "+aux.size());
        
        List<beanOpeDias> diasNoTrabajados = new ArrayList<>();
        for(Map.Entry<String,Integer> x:aux.entrySet()){
            beanOpeDias op = new beanOpeDias(x.getKey(),  x.getValue());
            diasNoTrabajados.add(op);
        }
        System.out.println("Tamaño lista: "+diasNoTrabajados.size());   
        
        //ordenación lista
        diasNoTrabajados.sort((beanOpeDias o1, beanOpeDias o2) ->  o2.getDias()-o1.getDias());
        
        diasNoTrabajados.stream().forEach((o) -> {
            System.out.println(o);
        });
    //Cerrar conexión
        em.close();
        emf.close();

    }
}