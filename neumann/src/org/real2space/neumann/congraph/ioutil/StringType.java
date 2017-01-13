package org.real2space.neumann.congraph.ioutil;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class StringType implements DataType<String> {
    private String data;
    public StringType(String value) {
        this.data = value;
    }
    @Override
    public String get() {
        return this.data;
    }
}
