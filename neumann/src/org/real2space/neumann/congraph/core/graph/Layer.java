package org.real2space.neumann.congraph.core.graph;

import java.util.HashSet;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
class Layer {
    private HashSet<Node> nodes;
    
    protected Layer() {
        this.nodes = new HashSet<Node>();
    }
    
    protected void addNode(Node node) {
        this.nodes.add(node);
    }
    
    protected void removeNode(Node node) {
        this.nodes.remove(node);
    }
    
    protected HashSet<Node> getNodes() {
        return this.nodes;
    }
}
