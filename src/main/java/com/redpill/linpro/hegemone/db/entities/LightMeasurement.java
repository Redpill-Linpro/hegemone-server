package com.redpill.linpro.hegemone.db.entities;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class LightMeasurement extends PanacheEntity {
    public int blue;

    public int green;

    public int red;

    @JsonbProperty("far_red")

    public int farRed;

    public int white;
}
