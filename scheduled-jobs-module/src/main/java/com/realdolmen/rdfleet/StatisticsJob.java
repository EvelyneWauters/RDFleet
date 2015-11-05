package com.realdolmen.rdfleet;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class StatisticsJob {

    @Scheduled(cron = "0 0 * * SUN")//Each sunday at midnight the statistics will be updated for all employees
    public void updateStatisticsForAllActiveEmployees() {
        //Updates the user statistics for all active users.
        //1)Fetch all users with a currentcar assigned to them.
        //2)Execute retrieveDataFromWebservice for each one of them.
        //3)Update their car mileage accordingly.
    }

    public void retrieveDataFromWebservice() {
        //Retrieves the most recent data from the webservice
        //1)Address the webservice correctly and retrieve all data for a given list of users/employees
        //2)Return this list of users and their corresponding data.
    }
}
