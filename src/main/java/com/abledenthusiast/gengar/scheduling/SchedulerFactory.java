package com.abledenthusiast.gengar.scheduling;

public class SchedulerFactory {

    public SchedulerFactory() {}

    public Scheduler getScheduler() {
        return new Scheduler.SchedulerBuilder()
                .setMaxQueueSize(500)
                .build();
    }
}