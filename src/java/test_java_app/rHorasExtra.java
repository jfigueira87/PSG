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

/*
Query:
@NamedQuery(name = "HandHrealOper.calculo", query = "SELECT h FROM 
HandHrealOper h WHERE h.horasExtraCliente > 0 OR h.horasExtraKn > 0"),
*/

public class rHorasExtra {

    //Cálculo horas extra
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        //no hace falta transacción, es operación de lectura
        //em.getTransaction().begin();
        Query q = em.createNamedQuery("HandHrealOper.calculoHorasExtra");
        //q.setParameter("A","A");
        List listado = q.getResultList();
        //em.getTransaction().commit();
        
        //System.out.println(listado);
        //System.out.println(listado.getClass());
        System.out.println("tamaño: "+listado.size());
        System.out.println(listado.get(0).getClass());
          
        List<beanOpeHoras> rankingHorasExtra = new ArrayList<>();
        HashMap<String, Double> aux = new HashMap<>();
        
        for(int i=0; i<listado.size(); i++){
            entidades.HandHrealOper ope = (entidades.HandHrealOper) listado.get(i);
            beanOpeHoras ohe = new beanOpeHoras(ope.getTrUsuarios().getUsuIdusuario(), 
                    ope.getHorasExtraCliente().doubleValue()+ope.getHorasExtraKn().doubleValue());
            if(aux.containsKey(ohe.getIdOperario())){
                aux.replace(ohe.getIdOperario(), aux.get(ohe.getIdOperario())+ohe.getHorasExtra() );
            }else{
                aux.put(ohe.getIdOperario(), ohe.getHorasExtra());
            }
        }
  
        System.out.println("Tamaño ranking: "+aux.size());
        
        for(Map.Entry<String,Double> x:aux.entrySet()){
            beanOpeHoras op = new beanOpeHoras(x.getKey(), x.getValue());
            rankingHorasExtra.add(op);
        } 
        
    //ordenación
        rankingHorasExtra.sort((beanOpeHoras o1, beanOpeHoras o2) -> 
                (int) ((o2.getHorasExtra()*100)-(100*o1.getHorasExtra())));
        
        rankingHorasExtra.stream().forEach((o) -> {
            System.out.println(o.toString());
        });
            
    //Cerrar conexión
        em.close();
        emf.close();

    }
    
}
