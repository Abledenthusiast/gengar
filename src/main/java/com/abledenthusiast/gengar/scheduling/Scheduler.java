package com.abledenthusiast.gengar.scheduling;

import java.util.concurrent.DelayQueue;

public class Scheduler {
    private DelayQueue<ExecutionTask> delayQ;
    private int maxQueueSize = 500;
    

    public Scheduler() {
        delayQ = new DelayQueue<>();
    }


    public int getNumOfTasks() {
        return delayQ.size();
    }
    

    public static class SchedulerBuilder {
        private int maxSize;

        public SchedulerBuilder() {}

        public SchedulerBuilder setMaxQueueSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Scheduler build() {
            Scheduler scheduler = new Scheduler();
            scheduler.maxQueueSize = this.maxSize;
            /* 
             Room for more fun!
            */
            return scheduler;
        }
    }
}