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
        System.out.println(origin.refData());
    }
}
