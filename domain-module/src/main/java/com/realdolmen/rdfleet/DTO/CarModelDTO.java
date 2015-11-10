package com.realdolmen.rdfleet.DTO;


import javax.persistence.Embeddable;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Created by JDOAX80 on 9/11/2015.
 */
public class CarModelDTO implements Serializable{
    private final String URL_PATTERN = "^(https?|ftp|file):\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]";

    @Size(min = 1, message = "{field.errorMessage.isEmpty}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private String modelName;
    private String modelDesignation;
    @Digits(integer = 10, fraction = 0, message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 0, message = "{field.errorMessage.mustNotBeNegative}")
    private Integer horsePower;
    private String versionName;
    @Pattern(message = "{field.errorMessage.invalidUrl}" , regexp = URL_PATTERN)
    private String imageUrl;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
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
                printIfNotNull(modelName) + " " + printIfNotNull(modelDesignation) + " "  + printIfNotNull(String.valueOf(horsePower)) + " pk" + " "  + printIfNotNull(versionName);
    }

    private String printIfNotNull(String stringToCheck) {
        if(stringToCheck != null && !stringToCheck.isEmpty()) {
            return stringToCheck;
        }
        else {
            return "";
        }
    }
}
