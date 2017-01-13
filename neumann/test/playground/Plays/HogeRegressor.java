package playground.Plays;

import org.real2space.neumann.congraph.Congraph;
import org.real2space.neumann.congraph.ioutil.DataFrame;

import javax.swing.*;

/**
 * Project Neumann
 * created 2017/01/14
 *
 * @author RealTwo-Space
 * @version 0
 */
public class HogeRegressor {
    DataFrame train;
    DataFrame test;
    Congraph cg;

    public HogeRegressor(DataFrame train, DataFrame test) {
        this.train = train;
        this.test = test;
        this.cg = new Congraph();
    }

    public void init() {

    }

    // graph class
    public class Chart extends JFrame {

    }
}
