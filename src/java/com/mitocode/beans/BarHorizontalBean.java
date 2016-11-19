package com.mitocode.beans;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean

public class BarHorizontalBean implements Serializable {

    private HorizontalBarChartModel horizontalBarModel;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    private void createBarModels() {
        createHorizontalBarModel();
    }

    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries frec = new ChartSeries();
        frec.setLabel("Frecuencia");
        frec.set("1", 50);
        frec.set("2", 96);
        frec.set("3", 44);
        frec.set("4", 55);
        frec.set("5", 25);

        horizontalBarModel.addSeries(frec);

        horizontalBarModel.setTitle("");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);

        xAxis.setMin(0);
        xAxis.setMax(100);

        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);

        horizontalBarModel.setSeriesColors("58BA27");
        
        
    }

}
