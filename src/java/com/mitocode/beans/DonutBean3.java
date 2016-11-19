
package com.mitocode.beans;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.DonutChartModel;
 
@ManagedBean
public class DonutBean3 implements Serializable {
 
    private DonutChartModel donutModel1;
 
    @PostConstruct
    public void init() {
        createDonutModels();
    }
 
    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }
     
     
    private void createDonutModels() {
        donutModel1 = initDonutModel();
        donutModel1.setTitle("Empresa 01");
        donutModel1.setLegendPosition("w");
        donutModel1.setSeriesColors("0101DF,2E64FE,58ACFA,A9E2F3");
         
    }
 
    private DonutChartModel initDonutModel() {
        DonutChartModel model = new DonutChartModel();
         
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        circle1.put("Brand 1", 150);
        circle1.put("Brand 2", 400);
        circle1.put("Brand 3", 200);
        circle1.put("Brand 4", 10);
        model.addCircle(circle1);
         
         
        return model;
    }
}

