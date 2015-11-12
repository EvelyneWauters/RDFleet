package com.realdolmen.rdfleet.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by JDOAX80 on 11/11/2015.
 */

@ComponentScan({"com.realdolmen.rdfleet.services", "com.realdolmen.rdfleet.repositories"})
@EnableTransactionManagement
public class ServicesConfig {
}
