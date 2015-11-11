package com.realdolmen.rdfleet.entities.car.options;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EWTAX45 on 9/11/2015.
 */
public class OptionListObject implements Serializable {
    private List<String> selectedOptions;

    public OptionListObject() {
    }

    public OptionListObject(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
