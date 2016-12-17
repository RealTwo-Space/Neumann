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

        System.out.println("While loop");
        while(!stack.isEmpty()) {
            System.out.println("While loop start");
            Group group = stack.pop();
            System.out.println("if start");
            if (it.hasNext()) {
                System.out.println("hasnext");
                it.next().addGroup(group);
            } else {
                System.out.println("!hasnext");
                System.out.println("going to addlayer" + it.previousIndex() + " " + it.nextIndex());
                it.add(new Layer());
                System.out.println("addlayer" + it.previousIndex() + " " + it.nextIndex());
                // ここかえた
                it.previous().addGroup(group);
                it.next();
                System.out.println("has next? " + it.hasNext());
            }

            nodes = group.getNodes();
            boolean hasChildren = false;
            System.out.println("For start");
            for (int i = 0, n = nodes.length; i < n; i++) {
                Group children = graph.getChildren(nodes[i]);
                if (children != null) {
                    stack.push(children);
                    hasChildren = true;
                }
                System.out.println(hasChildren + " " + i);
            }
            System.out.println("For ends");

            System.out.println("Second if start");
            if (!hasChildren) {
                //it.previous();
            }
        }
        
        return schedule;
    }
}
