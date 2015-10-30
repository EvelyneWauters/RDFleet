package com.realdolmen.rdfleet.entities.car.embedabbles;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Embeddable
public class CarModel {

    @Column(nullable = false)
    private String modelName;
    private String modelDesignation;
    private String horsePower;
    private String versionName;
    private String imageUrl;


    public CarModel() {
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String name) {
        this.modelName = name;
    }

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return
                modelName + modelDesignation + horsePower + versionName;
    }
}
