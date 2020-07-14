package com.solvay.spring;

import com.solvay.spring.examples.AnotherBean;
import com.solvay.spring.examples.ExampleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnotherBean anotherBean = applicationContext.getBean("anotherBean", AnotherBean.class);
        anotherBean.show();

        ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);

        exampleBean.printInfo();
    }
}
