package com.realdolmen.rdfleet.services.DTO;

import java.io.Serializable;

/**
 * Created by JDOAX80 on 7/11/2015.
 */
public class AbstractDTO implements Serializable {

    private Long id;
    private Long versionNumber;

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
