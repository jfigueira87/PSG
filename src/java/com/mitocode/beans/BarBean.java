
package com.mitocode.beans;

 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class BarBean implements Serializable {
 
    private BarChartModel barModel;
    
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries dia = new ChartSeries();
        dia.setLabel("dia");
        dia.set("1", 120);
        dia.set("2", 100);
        dia.set("3", 44);
        dia.set("4", 150);
        dia.set("5", 25);
        dia.set("6", 120);
        dia.set("7", 100);
        dia.set("8", 44);
        dia.set("9", 150);
        dia.set("10", 25);
        dia.set("21", 120);
        dia.set("22", 100);
        dia.set("23", 44);
        dia.set("24", 150);
        dia.set("25", 25);
        dia.set("26", 120);
        dia.set("27", 100);
        dia.set("28", 44);
        dia.set("29", 150);
        dia.set("30", 25);
        dia.set("31", 25);
 
        model.addSeries(dia);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("GRÁFICO DE ACTIVIDAD");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("DÍAS");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("ACTIVIDAD");
        yAxis.setMin(0);
        yAxis.setMax(200);
        barModel.setSeriesColors("F52F2F");
        
    }
    
}
