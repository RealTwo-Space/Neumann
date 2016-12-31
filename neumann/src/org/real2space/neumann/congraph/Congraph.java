package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class Congraph {
    private final CongraphInterface cgi;

    public Congraph() {
        this.cgi = new CongraphInterface();
    }

    public CNode constant(double value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this.cgi);
    }

    public CNode constant(double[][] value) {
        Node node = this.cgi.constant(new Matrix64(value));
        return new CNode(node, this.cgi);
    }

    public CNode constant(Matrix64 value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this.cgi);
    }

    public CNode variable(double value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this.cgi);
    }

    public CNode variable(double[][] value) {
        Node node = this.cgi.variable(new Matrix64(value));
        return new CNode(node, this.cgi);
    }

    public CNode variable(Matrix64 value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this.cgi);
    }

    public CNode add(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.add(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode subtract(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.subtract(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode multiply(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.multiply(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode divide(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.divide(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode substitute(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.substitute(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode normSq(CNode nodeA) {
        Node node = this.cgi.normSquared(nodeA.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode partialDiff(CNode target, CNode by) {
        Node node = this.cgi.partialDiff(target.getNode(), by.getNode());
        return new CNode(node, this.cgi);
    }

    public void execute(CNode node) {
        this.cgi.execute(node.getNode());
    }
}
