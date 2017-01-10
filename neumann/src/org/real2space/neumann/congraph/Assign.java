package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.congraph.core.data.*;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2017/01/02.
 */
public class Assign {
    private Node node;
    private Data data;

    Assign(Node node, Data data) {
        this.node = node;
        this.data = data;
    }

    Data getData() {
        return this.data;
    }

    void setData(Data data) {
        this.data = data;
    }

    Node getNode() {
        return this.node;
    }
}
