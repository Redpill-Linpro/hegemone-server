package com.redpill.linpro.hegemone.db.entities;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class DeviceMeasurement extends PanacheEntity {
    @JsonbProperty(value = "device_id", nillable = true)
    public String deviceId;

    @JsonbProperty(value = "light_measurement", nillable = true)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public LightMeasurement lightMeasurement;

    @JsonbProperty(value = "soil_temp", nillable = true)
    public double soilTemp;

    @JsonbProperty(value = "ambient_temp", nillable = true)
    public double ambientTemp;

    @JsonbProperty(value = "moisture_level", nillable = true)
    public int moistureLevel;
    @JsonbProperty(value = "spectral_data", nillable = true)
    public int[] spectralData;

    @CreationTimestamp
    @JsonbProperty(value = "date_time")
    public LocalDateTime dateTime;
}
