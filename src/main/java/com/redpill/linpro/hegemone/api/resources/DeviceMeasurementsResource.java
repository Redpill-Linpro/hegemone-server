package com.redpill.linpro.hegemone.api.resources;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redpill.linpro.hegemone.db.entities.DeviceMeasurement;

import io.quarkus.logging.Log;

@Path("/device-measurements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceMeasurementsResource {

    @GET
    public List<DeviceMeasurement> list(@QueryParam("device_id") String deviceIdParam) {
        if(deviceIdParam != null) {
            Log.debug("Fetching DeviceMeasurements with deviceId: " + deviceIdParam);
            return DeviceMeasurement.list("deviceId", deviceIdParam);
        }
        Log.debug("Fetching all DeviceMeasurements");
        return DeviceMeasurement.listAll();
    }

    @GET
    @Path("/{id}")
    public DeviceMeasurement get(@PathParam("id") Long id) {
        Log.debug("Fetching DeviceMeasurement with id: " + id);
        return DeviceMeasurement.findById(id);
    }

    @POST
    @Transactional
    public Response create(DeviceMeasurement deviceMeasurement) {
        Log.debug("Creating new DeviceMeasurement");
        deviceMeasurement.persist();
        return Response.created(URI.create("/device-measurements/" + deviceMeasurement.id)).build();
    }

    @GET
    @Path("/health")
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "I'M ALIVE!";
    }

}