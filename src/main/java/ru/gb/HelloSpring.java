package ru.gb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        // System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();
        context.close();
    }
}
