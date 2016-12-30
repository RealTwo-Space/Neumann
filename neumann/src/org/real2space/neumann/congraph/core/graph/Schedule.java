package org.real2space.neumann.congraph.core.graph;

import java.util.LinkedList;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
public class Schedule {
    private Node origin;
    private LinkedList<Layer> layers;
    
    protected Schedule(Node origin) {
        this.layers = new LinkedList<Layer>();
        this.origin = origin;
    }
    
    protected Node getOrigin () {
        return this.origin;
    }
    
    protected void addLayer(Layer layer) {
        this.layers.add(layer);
    }
    
    protected LinkedList<Layer> getLayers() {
        return this.layers;
    }
}
