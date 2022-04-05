package com.redpill.linpro.hegemone.quartz;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redpill.linpro.hegemone.db.entities.DeviceMeasurement;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Parameters;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class CleanupTask {

    @ConfigProperty(name = "entity.age.seconds")
    int entityAgeSecods;

    @Transactional
    @Scheduled(every = "60s", identity = "cleanup-task")
    void schedule() {
        Log.debug("Running cleanup task");

        LocalDateTime oldestAllowedDateTime = LocalDateTime
                .ofInstant(Instant.now().minus(entityAgeSecods, ChronoUnit.SECONDS), ZoneId.systemDefault());

        Log.debug("Deleting DeviceMeasurements created before " + oldestAllowedDateTime);

        long deletedEntites = DeviceMeasurement.delete("dateTime < :oldestAllowedDateTime",
                Parameters.with("oldestAllowedDateTime", oldestAllowedDateTime));

        Log.debug("Deleted " + deletedEntites + " entities");
    }
}
