package com.abledenthusiast.gengar.scheduling;

import java.time.Instant;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ExecutionTask implements Delayed {
    private Instant timeToExecute;
    
    public ExecutionTask() {

    }

    @Override
    public int compareTo(Delayed other) {
        if (other.getDelay(TimeUnit.MILLISECONDS) < this.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeToExecute.toEpochMilli() - Instant.now().toEpochMilli(), 
                            TimeUnit.MILLISECONDS);
	}
}