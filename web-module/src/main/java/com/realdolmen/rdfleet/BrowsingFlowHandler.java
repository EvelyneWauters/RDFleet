package com.realdolmen.rdfleet;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class BrowsingFlowHandler extends AbstractFlowHandler {

    //TODO:Change URL
    private static final String DEFAULT_URL = "/";

    @Override
    public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest request,
                                         HttpServletResponse response) {
        return DEFAULT_URL;
    }

    @Override
    public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response) {
        if (e instanceof NoSuchFlowExecutionException) {
            return DEFAULT_URL;
        } else {
            throw e;
        }
    }

}

