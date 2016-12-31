package org.real2space.neumann.congraph;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class CNode {
    private final Node node;
    private final CongraphInterface cgi;

    CNode(Node node, CongraphInterface cgi) {
        this.node = node;
        this.cgi = cgi;
    }

    Node getNode() {
        return this.node;
    }

    public CNode add(CNode nodeB) {
        Node node = this.cgi.add(this.node, nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode subtract(CNode nodeB) {
        Node node = this.cgi.subtract(this.node, nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode multiply(CNode nodeB) {
        Node node = this.cgi.multiply(this.node, nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode divide(CNode nodeB) {
        Node node = this.cgi.divide(this.node, nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode substitute(CNode nodeB) {
        Node node = this.cgi.substitute(this.node, nodeB.getNode());
        return new CNode(node, this.cgi);
    }

    public CNode normSq() {
        Node node = this.cgi.normSquared(this.node);
        return new CNode(node, this.cgi);
    }

    public CNode partialDiff(CNode by) {
        Node node = this.cgi.partialDiff(this.node, by.getNode());
        return new CNode(node, this.cgi);
    }

    public void execute() {
        this.cgi.execute(this.node);
    }

    public Data getData() {
        return this.node.getData();
    }
}
