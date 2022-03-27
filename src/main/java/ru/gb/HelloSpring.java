package ru.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); заменяем на:
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();
        context.close();
    }
}
