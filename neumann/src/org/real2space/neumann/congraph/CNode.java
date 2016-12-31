package org.real2space.neumann.congraph;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class CNode {
    private final Node node;
    private final Congraph cg;

    CNode(Node node, Congraph cg) {
        this.node = node;
        this.cg = cg;
    }

    Node getNode() {
        return this.node;
    }

    public CNode add(CNode nodeB) {
        return cg.add(this, nodeB);
    }

    public CNode subtract(CNode nodeB) {
        return cg.subtract(this, nodeB);
    }

    public CNode multiply(CNode nodeB) {
        return cg.multiply(this, nodeB);
    }

    public CNode divide(CNode nodeB) {
        return cg.divide(this, nodeB);
    }

    public CNode substitute(CNode nodeB) {
        return cg.substitute(this, nodeB);
    }

    public CNode incrementalSubstitute(CNode node) {
        return cg.incrementalSubstitute(this, node);
    }

    public CNode decrementalSubstitute(CNode node) {
        return cg.decrementalSubstitute(this, node);
    }

    public CNode normSq() {
        return cg.normSq(this);
    }

    public CNode partialDiff(CNode by) {
        return cg.partialDiff(this, by);
    }

    public void execute() {
        cg.execute(this);
    }

    public Data getData() {
        return this.node.getData();
    }

    public String toString() {
        return this.node.toString();
    }
}
