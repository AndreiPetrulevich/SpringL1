package ru.gb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class WantMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String foodStuff;

    public WantMessageProvider() {
        System.out.println("FoodStuff from constructor: " + foodStuff);
    }

    @PostConstruct
    public void init() { // вызывается при создании бина
        System.out.println("FoodStuff from init: " + foodStuff);
    }

    @PreDestroy
    public void preDestroy() { //метод вызываемый при закрытии контекста
        System.out.println("FoodStuff from preDestroy: " + foodStuff);
    }

    @Override
    public String getMessage() {
        return "I want " + foodStuff;
    }
}
