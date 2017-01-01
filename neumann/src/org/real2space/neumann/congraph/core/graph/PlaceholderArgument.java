package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;

/**
 * Created by ryosukesuzuki on 2017/01/02.
 */
public class PlaceholderArgument extends Argument {
    private Data arg;

    protected PlaceholderArgument() {
        this.arg = null;
    }

    protected void setData(Data arg) {
        this.arg = arg;
    }

    @Override
    public Data getDataAt(int index) {
        return this.arg;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
