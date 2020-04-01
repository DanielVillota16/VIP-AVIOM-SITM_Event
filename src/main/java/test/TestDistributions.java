package test;

import org.apache.commons.math3.distribution.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDistributions {
    public static void main(String[] args){
        AbstractRealDistribution dist = new NormalDistribution(0,3);
        double[] x = dataGen(dist);
        HashMap<Double,Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            if(!map.containsKey(x[i])){
                map.put(x[i],1);
            } else {
                map.replace(x[i], map.get(x[i])+1);
            }
        }
        double[] freqs = new double[1000];
        for (int i = 0; i < 1000; i++) {
            freqs[i] = map.get(x[i]);
        }
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);
        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            yData.add(freqs[i]);
            xData.add(x[i]);
        }
        chart.addSeries("Distribution", xData, yData);
        new SwingWrapper<XYChart>(chart).displayChart();
    }

    public static double[] dataGen(AbstractRealDistribution dist){
        double[] data = dist.sample(1000);
        for (int i = 0; i < 1000; i++) data[i] = (int)data[i];
        return data;
    }

}
