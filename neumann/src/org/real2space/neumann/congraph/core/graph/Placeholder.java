package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 01/02/16
 */
public class Placeholder extends State {
    private PlaceholderArgument arg;

    public Placeholder() {
        this.arg = new PlaceholderArgument();
    }

    public void setData(Data data) {
        this.arg.setData(data);
    }

    @Override
    public Data execute() {
        return this.arg.getDataAt(0);
    }
}
