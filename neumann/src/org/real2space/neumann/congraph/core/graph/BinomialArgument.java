package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/29/16
 */

// 全体的に変えたよ
public class BinomialArgument extends Argument {
    private Node[] args;
    
    public BinomialArgument(Node argL, Node argR) {
        this.args = new Node[2];
        this.args[0] = argL;
        this.args[1] = argR;
    }
    
    public Data getDataAt(int index) {
        return this.args[index].refData();
    }
    
    public int getSize() {
        return 2;
    }
}
