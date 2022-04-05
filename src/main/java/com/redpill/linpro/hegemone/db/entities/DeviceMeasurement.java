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
    @JsonbProperty("device_id")
    public String deviceId;

    @JsonbProperty("light_measurement")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public LightMeasurement lightMeasurement;

    @JsonbProperty("soil_temp")
    public double soilTemp;

    @JsonbProperty("ambient_temp")
    public double ambientTemp;

    @JsonbProperty("moisture_level")
    public int moistureLevel;

    @CreationTimestamp
    public LocalDateTime date;
}
