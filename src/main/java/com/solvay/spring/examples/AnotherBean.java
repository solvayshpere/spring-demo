package com.solvay.spring.examples;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AnotherBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {
    private String name;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnotherBean(){
        System.out.println("开始实例化AnotherBean...");
    }

    public void show(){
        System.out.println(name);
        AnotherBean bean = applicationContext.getBean(AnotherBean.class);
        System.out.println(bean.name);
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("开始配置BeanName： " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("开始配置BeanFactory: " + beanFactory.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("开始配置ApplicationContext: " + applicationContext.toString());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("开始调用BeanPostprocessBefore:" + beanName);
        System.out.println(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("开始调用BeanPostprocessAfter:" + beanName);
        System.out.println(bean);
        return bean;
    }

    @Override
    public String toString() {
        return "AnotherBean{" +
                "name='" + name + '\'' +
                ", beanFactory=" + beanFactory +
                ", applicationContext=" + applicationContext +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("开始调用InitializingBean >> afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("开始调用DisposableBean >> destroy");
    }
}
