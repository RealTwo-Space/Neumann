package playground.Plays;

import playground.Util.DataFrame;

/**
 * Project Neumann
 * created 2017/01/12
 *
 * @author RealTwo-Space
 * @version 0
 */

public class DataFrameTest {
    public static void main(String[] args) {

        DataFrame df = DataFrame.readCSV("../data/MER_T12_06.csv");
        //df.head();
    }
}
