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
import entidades.VHandDesviosTiempos;
import entidades.HandDesviosTiempos2;
/*
hay que aplicar el script de creación de tabla creado a través del script de vista 
*/
public class rDesvios {

    //Cálculo desvios
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("HandDesviosTiempos2.findAll");
        List listado = q.getResultList();
        System.out.println(listado.get(0).getClass());
        
        List<beanOpeDesvios> aux1 = new ArrayList<>();
        List<String> operarios = new ArrayList<>();
        List<beanOpeDesvios> rankingDesvios = new ArrayList<>();
        
        for (Object l : listado) {
            HandDesviosTiempos2 vdes = (HandDesviosTiempos2) l;
            beanOpeDesvios bod = new beanOpeDesvios(vdes.getOperario(), vdes.getTiempoTotal(), vdes.getTiempoMedio());
            aux1.add(bod);
            if(!operarios.contains(vdes.getOperario())){
                operarios.add(vdes.getOperario());
            }
            //System.out.println(bod.toString());
        }
        for(beanOpeDesvios b:aux1){
            //System.out.println(b.toString());
        }
        
        for(String op:operarios){
            int ok = 0;
            int total = 0;
            for(beanOpeDesvios b:aux1){
                if(op.equals(b.getIdOperario())){
                    total++;
                    if(b.getDesviosOK()<=b.getDesviosTotal()){
                        ok++;                                                
                    }
                }
            }
            beanOpeDesvios opDes = new beanOpeDesvios(op, ok, total);
            rankingDesvios.add(opDes);
        }
        rankingDesvios.sort((beanOpeDesvios c1, beanOpeDesvios c2) -> c2.getDesviosOK()-c1.getDesviosOK());
        rankingDesvios.stream().forEach( x -> System.out.println(x.toString()));
        
        System.out.println(listado.getClass());
        System.out.println("tamaño: "+listado.size());
        System.out.println(listado.get(1).getClass());
        System.out.println("Tamaño list Operarios: "+operarios.size());
        System.out.println("Tamaño ranking desvios: "+rankingDesvios.size());
    //Cerrar conexión
        em.close();
        emf.close();

    }
    
}