package com.redpill.linpro.hegemone.db.entities;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class LightMeasurement extends PanacheEntity {

    @JsonbProperty(nillable = true)
    public int blue;

    @JsonbProperty(nillable = true)
    public int green;

    @JsonbProperty(nillable = true)
    public int red;

    @JsonbProperty(value = "far_red", nillable = true)
    public int farRed;

    @JsonbProperty(nillable = true)
    public int white;
}
