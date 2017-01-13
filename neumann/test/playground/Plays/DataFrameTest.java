package playground.Plays;

import org.real2space.neumann.congraph.ioutil.DataFrame;

/**
 * Project Neumann
 * created 2017/01/12
 *
 * @author RealTwo-Space
 * @version 0
 */

public class DataFrameTest {
    public static void main(String[] args) {
        DataFrame df = DataFrame.readCSV("./neumann/test/playground/data/MER_T12_06.csv");
        DataFrame dammies = df.getDammies("MSN", "Description" ,"Unit");
        df.head();
        dammies.head();
        dammies.combine(df.remove("MSN", "Description" ,"Unit")).tail(10);
        DataFrame number = df.remove("MSN", "Description" ,"Unit");//.sum().head();
        number.head();
        DataFrame value = number.removeColumnWithKey("Not Available");
        value.getRow("Value").divide(100.0).head();
    }
}
