package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/28/16
 */
public class Node {
    private Data data;
    private State state;
    
    protected Node(Data data, State state) {
        this.data = data;
        this.state = state;
    }
    
    protected void execute() {
        this.data = this.state.execute();
    }
    
    // return refenrence
    protected Data refData() {
        return this.data;
    }
    
    // deep copy and return (for users)
    public Data getData() {
        return null;
    }
    
    public String toString() {
        return this.data.toString() + " : " + this.state.toString();
    }
}
