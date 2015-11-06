package com.realdolmen.rdfleet.scheduledjobs.config;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.realdolmen.rdfleet")
public class ScheduledJobsConfig {

}
