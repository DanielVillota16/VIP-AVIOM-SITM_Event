package ui;

import model.ProbabilisticDistribution;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import test.PDTest;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String type = "ChiSquaredDistribution", arg1 = "degreesOfFreedom", arg2 = "sd";
        Hashtable<String, Object> params = new Hashtable<>();
        params.put(arg1, 5.0);
        //params.put(arg2, 2.0);
        ProbabilisticDistribution pd = new ProbabilisticDistribution(type, params);
        PDTest test = new PDTest(1000, pd);
        showData(test.xData,test.yData);
    }

    public static void showData(List<Double> xData, List<Double> yData){
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);
        chart.addSeries("Distribution", xData, yData);
        new SwingWrapper<XYChart>(chart).displayChart();
    }
}
