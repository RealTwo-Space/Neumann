package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          
 * created 12/29/16
 */
 
public class BackPropagationPool {
    private HashMap<Node, Data> partials;
    private Schedule schedule;
    
    public BackPropagationPool(Schedule schedule) {
        this.partials = new HashMap<Node, Data>();
        this.schedule = schedule;
        
        LinkedList<Layer> layers = this.schedule.getLayers();
        HashSet<Node> nodes;
        Node origin = this.schedule.getOrigin();
        // set to zero
        partials.put(origin, origin.getData());
        for (Layer layer : layers) {
            nodes = layer.getNodes();
            for (Node node : nodes) {
                // set to zero
                partials.put(node, node.getData());
            }
        }
    }
    
    public Data getData(Node node) {
        return this.partials.get(node);
    }
}

/*

cg.partialOp(funcNode, node);

funcNode以下のNodeを参照しながらやればよいと．
どのLayersにFuncNodeが含まれているかわかれば，おっけーじゃない？

funcNodeを定義した時点で，すでにfuncNodeをoriginとした，Scheduleが作れる．
cg.parialOp(funcNode, node)
congraph void pariOp () {
    scheduler.createSchedule(funcNode);
}
Layers = {li}

*/