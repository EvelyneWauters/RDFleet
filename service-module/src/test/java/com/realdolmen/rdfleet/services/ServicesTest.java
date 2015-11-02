package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.services.config.ServicesConfig;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = ServicesConfig.class)
public class ServicesTest extends Assert {
}
