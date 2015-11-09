package com.realdolmen.rdfleet.DTO;


import javax.persistence.Embeddable;
import javax.validation.constraints.*;

/**
 * Created by JDOAX80 on 9/11/2015.
 */
@Embeddable
public class CarModelDTO {
    private final String URL_PATTERN = "^(https?|ftp|file):\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]";

    @Size(min = 1, message = "This field can not be left empty")
    @NotNull
    private String modelName;
    private String modelDesignation;
    @Digits(integer = 10, fraction = 0, message = "This must be a number")
    @Min(value = 0, message = "Value can't be negative")
    private int horsePower;
    private String versionName;
    @Pattern(message = "This is an invalid url" , regexp = URL_PATTERN)
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

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
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
