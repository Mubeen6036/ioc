package com.example.ioc;

import com.example.ioc.postprocessor.SampleBeanFactoryPostProcessor;
import com.example.ioc.postprocessor.SampleBeanPostProcessor;
import com.example.ioc.service.UserService;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
//    @Bean
//    public static SampleBeanFactoryPostProcessor getSampleBeanFactoryPostProcessor(){
//        return new SampleBeanFactoryPostProcessor();
//    }
//    @Bean
//    public static SampleBeanPostProcessor getSampleBeanPostProcessor(){
//        return new SampleBeanPostProcessor();
//    }
}
