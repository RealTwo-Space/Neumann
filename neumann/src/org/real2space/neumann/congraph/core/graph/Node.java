package org.real2space.neumann.congraph.core.graph;
import org.real2space.neumann.congraph.core.data.Data;
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
    
    public Node(Data data, State state) {
        this.data = data;
        this.state = state;
    }
    
    protected void execute() {
        this.data = this.state.execute();
    }
    
    // return refenrence
    public Data refData() {
        return this.data;
    }
    
    public Data getData() {
        return data.deepCopy();
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    public String toString() {
        return this.data.toString() + " : ";// + this.state.toString();
    }
}