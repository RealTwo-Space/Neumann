package org.real2space.neumann.congraph.core.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;

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
    
    
    // TODO : write "if origin has no child"
    protected Schedule createSchedule(Node origin, Graph graph) {
        Schedule schedule = new Schedule(origin);
        
        Node[] nodes;
        LinkedList linkedList = schedule.getLayers();
        ListIterator<Layer> it = linkedList.listIterator();
        
        ArrayDeque<Group> stack = new ArrayDeque<Group>();
        stack.push(graph.getChildren(origin));
        
        while(!stack.isEmpty()) {
            Group group = stack.pop();
            if (it.hasNext()) {
                it.next().addGroup(group);
            } else {
                it.add(new Layer());
                it.next().addGroup(group);
            }
            
            nodes = group.getNodes();
            boolean hasChildren = false;
            for (int i = 0, n = nodes.length; i < n; i++) {
                Group children = graph.getChildren(nodes[i]);
                if (children != null) {
                    stack.push(children);
                    hasChildren = true;
                }
            }
            
            if (!hasChildren) {
                it.previous();
            }
        }
        
        return schedule;
    }
}
