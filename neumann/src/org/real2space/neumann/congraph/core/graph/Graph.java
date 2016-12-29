package org.real2space.neumann.congraph.core.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
 
class Graph {
    private HashSet<Node> nodes;
    private HashMap<Node, Group> edges;
    
    protected Graph() {
        this.nodes = new HashSet<Node>();
        this.edges = new HashMap<Node, Group>();
    }
    
    protected void addNode(Node node) {
        this.nodes.add(node);
    }

    protected void addEdge(Node node, Group group) {
        this.edges.put(node, group);
    }
    
    protected Group getChildren(Node node) {
        return this.edges.get(node);
    }
    
    protected HashSet<Node> getNodes() {
        return this.nodes;
    }
}
