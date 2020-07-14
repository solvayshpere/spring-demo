package com.solvay.spring.examples;

import java.beans.ConstructorProperties;

public class ExampleBean {

    private int years;

    private String ultimateAnswer;

    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer){
        System.out.println("开始实例化ExampleBean...");
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    public void printInfo(){
        System.out.println("years:" + years + ", ultimateAnswer:" + ultimateAnswer);
    }
}
