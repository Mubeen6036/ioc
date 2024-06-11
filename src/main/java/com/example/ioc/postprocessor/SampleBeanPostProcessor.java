package com.example.ioc.postprocessor;

import com.example.ioc.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SampleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before Init");
        System.out.println(bean.toString());
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before Init");
        System.out.println(bean.toString());
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
