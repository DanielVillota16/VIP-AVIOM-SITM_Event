package test;

import model.ProbabilisticDistribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PDTest {

    public List<Double> xData;
    public List<Double> yData;
    public ProbabilisticDistribution pd;
    public int size;

    public PDTest(int size, ProbabilisticDistribution pd){
        this.size = size;
        this.pd = pd;
        this.xData = xData();
        this.yData = freqCounter();
    }

    public List<Double> xData(){
        List<Double> xData = new ArrayList<>();
        for (int i = 0; i < size; i++) xData.add(pd.getNextDistributionValue());
        return xData;
    }

    public List<Double> freqCounter(){
        List<Double> yData = new ArrayList<>();
        HashMap<InclusiveRange,Integer> map = new HashMap<>();
        double min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        //find minimum and maximum values of the xData list in order to know the limits of the intervals
        for (int i = 0; i < size; i++) {
            if(xData.get(i) < min) min = xData.get(i);
            if(xData.get(i) > max) max = xData.get(i);
        }
        //create an arbitrary number of intervals and put them into the hashmap
        double numOfRanges = 10;
        double rangeLength = (max-min)/numOfRanges;
        for (int i = 1; i <= numOfRanges; i++) {
            InclusiveRange ir = new InclusiveRange(min+rangeLength*(i-1),min+rangeLength*i);
            map.put(ir,0);
        }
        //for each value in xData verify which interval does it fit in and sum one to its respective value in the hashmap
        for (int i = 0; i < size; i++) {
            double val = xData.get(i);
            InclusiveRange ir = null;
            for (InclusiveRange rng: map.keySet()) {
                if(rng.left<= val && rng.right >= val) {
                    ir = rng;
                    break;
                }
            }
            map.replace(ir, map.get(ir)+1);
        }
        //finally every value in the hashmap is put into the yData list so its values matches with the values of
        //the xData list
        for (int i = 0; i < size; i++) {
            InclusiveRange ir = null;
            double val = xData.get(i);
            for (InclusiveRange rng: map.keySet()) {
                if(rng.left<= val && rng.right >= val) {
                    ir = rng;
                    break;
                }
            }
            yData.add((double)map.get(ir));
        }
        return yData;
    }

    public class InclusiveRange implements Comparable<InclusiveRange>{

        public double left;
        public double right;

        public InclusiveRange(double left, double right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(InclusiveRange o) {
            int ans;
            if(left==o.left && right==o.right){
                ans = 0;
            } else{
                if(left<o.left){
                    ans = -1;
                } else if(left==o.left){
                    if(right<o.right){
                        ans = -1;
                    } else {
                        ans = 1;
                    }
                } else {
                    ans = 1;
                }
            }
            return ans;
        }
    }

}
