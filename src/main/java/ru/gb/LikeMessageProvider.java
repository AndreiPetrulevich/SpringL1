package ru.gb;

public class LikeMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String foodStuff;

    @Override
    public String getMessage() {
        return "I like " + foodStuff;
    }
}
