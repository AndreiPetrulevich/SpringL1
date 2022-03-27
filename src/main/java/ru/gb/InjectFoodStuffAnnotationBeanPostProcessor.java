package ru.gb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Retention;
import java.lang.reflect.Field;
import java.util.Random;

@Component // используется для создания бина, в context.xml при этом необходимо прописать component-scan
public class InjectFoodStuffAnnotationBeanPostProcessor implements BeanPostProcessor {

    String[] food = {"meat", "cookie", "fish", "apple"};

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        for(Field field : bean.getClass().getDeclaredFields()) {
            InjectFoodStuff annotation = field.getAnnotation(InjectFoodStuff.class);
            if (annotation != null) {
                Random random = new Random();
                String foodStuff = food[random.nextInt(food.length - 1)];
                field.setAccessible(true); //для предоставления возможности изменения field
                ReflectionUtils.setField(field, bean, foodStuff); // присваиваем значение
            }
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
