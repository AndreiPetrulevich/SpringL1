package ru.gb;

public class WantMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String foodStuff;

    @Override
    public String getMessage() {
        return "I want " + foodStuff;
    }
}
