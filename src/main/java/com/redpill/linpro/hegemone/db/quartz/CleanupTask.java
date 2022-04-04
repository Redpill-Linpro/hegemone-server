package com.redpill.linpro.hegemone.db.quartz;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redpill.linpro.hegemone.db.entities.DeviceMeasurement;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class CleanupTask {
    
    @Transactional
    @Scheduled(every = "10s", identity = "cleanup-task")
    void schedule() {
        Log.info("Running cleanup task...");
    }
}
