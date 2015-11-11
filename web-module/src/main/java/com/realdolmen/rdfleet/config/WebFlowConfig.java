package com.realdolmen.rdfleet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

import java.util.Arrays;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Autowired
    private WebMvcConfig webMvcConfig;

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
//                .addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
//                of
//                .addFlowExecutionListener(securityListener())
//                .addFlowExecutionListener(persistenceListener())
                .build();
    }


    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
                .setBasePath("classpath:flows")
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }


    @Bean(name = "bla")
    public DefaultConversionService conversionService() {
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(this.webMvcConfig.carModelConverter);
        defaultConversionService.addConverter(this.webMvcConfig.brandConverter);
        defaultConversionService.addConverter(this.webMvcConfig.carTypeConverter);
        return defaultConversionService;
    }



    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(mvcViewFactoryCreator())
                .setValidator(validator())
                .setDevelopmentMode(true)
                .build();
    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(this.webMvcConfig.ajaxThymeleafViewResolver()));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
