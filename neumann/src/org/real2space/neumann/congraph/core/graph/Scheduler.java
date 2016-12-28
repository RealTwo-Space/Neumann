package org.real2space.neumann.congraph.core.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashMap;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/03/16
 */
public class Scheduler {
    private static final Scheduler singleton = new Scheduler();
    
    private Scheduler() {}
    
    protected static Scheduler getInstance() {
        return singleton;
    }

    protected Schedule createSchedule(Node origin, Graph graph) {
        Schedule schedule = new Schedule(origin);
        
        Node[] nodes;
        LinkedList layers = schedule.getLayers();
        ListIterator<Layer> it = layers.listIterator();
        
        ArrayDeque<Group> stack = new ArrayDeque<Group>();

        Group originsChildren = graph.getChildren(origin);
        
        HashMap<Node, Layer> belonging = new HashMap<Node, Layer>();
                
        if (originsChildren == null) {
            return schedule;
        }

        stack.push(originsChildren);

        while(!stack.isEmpty()) {
            Group group = stack.pop();
            if (it.hasNext()) {
                addGroup(group, belonging, it.next(), layers);
                //it.next().addGroup(group);
            } else {
                it.add(new Layer());
                addGroup(group, belonging, it.previous(), layers);
                //it.previous().addGroup(group);
                it.next();
            }

            nodes = group.getNodes();
            
            for (int i = 0, n = nodes.length; i < n; i++) {
                Group children = graph.getChildren(nodes[i]);
                if (children != null) {
                    stack.push(children);
                }
            }
        }
        
        return schedule;
    }
    
    // addGroup(ad,ad, it.next());
    // addGroup(group, it.previous());
    // n -> n-1 -> ... -> 0にじっこうされる(nから実行される)
    private void addGroup(Group group, HashMap<Node, Layer> belonging, Layer layer, LinkedList<Layer> layers) {
        Node[] nodes = group.getNodes();
        Node node;
        Layer currentBelongings;
        for (int i = 0, n = nodes.length; i < n; i++) {
            node = nodes[i];
            currentBelongings = belonging.get(node);
            if (!belongings.containsKey(node)) {
                belongings.put(node, layer);
                layer.addNode(node);
            } else if (layers.indexOf(currentBelongings) < layers.indexOf(layer)) {
                belongings.put(node, layer);
                currentBelongings.removeNode(node);
                layer.addNode(node);
            }
        }
    }
}

