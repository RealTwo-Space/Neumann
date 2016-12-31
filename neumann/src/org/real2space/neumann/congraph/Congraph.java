package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class Congraph {
    private final CongraphInterface cgi;
    public final CUtil util;

    public Congraph() {
        this.cgi = new CongraphInterface();
        this.util = new CUtil(this);
    }

    public Congraph(long randomSeed) {
        this.cgi = new CongraphInterface();
        this.util = new CUtil(this, randomSeed);
    }

    public CNode constant(double value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this);
    }

    public CNode constant(double[][] value) {
        Node node = this.cgi.constant(new Matrix64(value));
        return new CNode(node, this);
    }

    public CNode constant(Matrix64 value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this);
    }

    public CNode variable(double value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this);
    }

    public CNode variable(double[][] value) {
        Node node = this.cgi.variable(new Matrix64(value));
        return new CNode(node, this);
    }

    public CNode variable(Matrix64 value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this);
    }

    public CNode add(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.add(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode subtract(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.subtract(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode multiply(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.multiply(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode divide(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.divide(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode substitute(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.substitute(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode incrementalSubstitute(CNode nodeA, CNode nodeB) {
        CNode out = nodeA.add(nodeB);
        return substitute(nodeA, out);
    }

    public CNode decrementalSubstitute(CNode nodeA, CNode nodeB) {
        CNode out = nodeA.subtract(nodeB);
        return substitute(nodeA, out);
    }

    public CNode normSq(CNode nodeA) {
        Node node = this.cgi.normSquared(nodeA.getNode());
        return new CNode(node, this);
    }

    public CNode partialDiff(CNode target, CNode by) {
        Node node = this.cgi.partialDiff(target.getNode(), by.getNode());
        return new CNode(node, this);
    }

    public CNode batch(CNode... cnodes) {
        int size = cnodes.length;
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = cnodes[i].getNode();
        }
        Node node = this.cgi.batch(nodes);
        return new CNode(node, this);
    }

    public void execute(CNode node) {
        this.cgi.execute(node.getNode());
    }
}
