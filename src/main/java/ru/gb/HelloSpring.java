package ru.gb;

public class HelloSpring {
    public static void main(String[] args) {
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
    }
}
