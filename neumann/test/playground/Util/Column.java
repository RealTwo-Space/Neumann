package playground.Util;

import java.util.ArrayList;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class Column {
    ArrayList<DataType> data;
    public Column() {
        data = new ArrayList<DataType>();
    }

    public void add(String value) {
        try {
            data.add(new DoubleType(Double.parseDouble(value)));
        } catch (NumberFormatException e) {
            data.add(new StringType(value));
        }
    }

    public void add(DataType value) {
        data.add(value);
    }

    public DataType get(int index) {
        return data.get(index);
    }

    public double[] get() {
        int N = data.size();
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = (double)data.get(i).get();
        }
        return res;
    }

    public String toString() {
        String res = " | ";
        int N = data.size();
        for (int i = 0; i < N; i++) {
            res += data.get(i).get() + " | ";
        }
        return res;
    }
}