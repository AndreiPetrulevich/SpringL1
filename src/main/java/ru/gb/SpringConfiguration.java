package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // для Spring
@ComponentScan // Просканирует весь пакет в котором находится, можно указать отдельный пакет для сканирования так: @Component("ru.gb")
public class SpringConfiguration {

    @Bean
    public MessageProvider provider() {
        return new WantMessageProvider();
    }

    @Bean
    public MessageRender render() {
        return new ConsoleMessageRender(provider());
    }
}
