package org.real2space.neumann.congraph.core.graph;

import java.util.Arrays;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
class Group {
    private Node[] nodes;
    
    protected Group(Node[] nodes) {
        this.nodes = Arrays.copyOf(nodes, nodes.length);
    }
    
    protected Node[] getNodes() {
        return this.nodes;
    }

    protected Node getNode(int index) {
        return this.nodes[index];
    }

    protected int size() {
        return this.nodes.length;
    }
}
