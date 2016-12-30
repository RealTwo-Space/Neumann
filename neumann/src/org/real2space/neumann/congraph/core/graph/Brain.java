package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/04/16
 */
public class Brain {
    private Schedule schedule;
    private Scheduler scheduler;
    private ScheduleExecuter scheduleExecuter;
    public Graph graph;
    
    public Brain() {
        this.scheduler = Scheduler.getInstance();
        this.scheduleExecuter = ScheduleExecuter.getInstance();
        this.graph = new Graph();
    }
    
    public void execute(Node origin) {
        this.schedule = this.scheduler.createSchedule(origin, this.graph);
        this.scheduleExecuter.executeSchedule(this.schedule);
    }

    public Graph getGraph() {
        return this.graph;
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }
    
    public void addNode(Node node) {
        this.graph.addNode(node);
    }
    
    public void addEdge(Node node, Group group) {
        this.graph.addEdge(node, group);
    }
}
