package com.mitocode.beans;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class LinealBean implements Serializable {
 
    private LineChartModel lineModel1;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("MOVIMIENTOS 2016");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        lineModel1.setSeriesColors("FF0040,0000FF,2EFE2E");
    } 
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        
        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel("Series 3");
 
        series3.set(1, 7);
        series3.set(3, 2);
        series3.set(2, 4);
        series3.set(4, 5);
        series3.set(5, 7);
 
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
        
        return model;
    }
     
 
}