package ru.project;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ru.project");
    }
}

@Configuration
class Config {
    @Qualifier("inject this")
    @Bean
    Logic logic2() {
        return new Logic();
    }

    @Bean
    List<Logic> logicList() {
        return List.of();
    }

    @Bean
    Comparator<Integer> comparator(@Qualifier("inject this") Logic logic3) {
        System.out.println(logic3);
        return (x, y) -> x - y;
    }
}

@Qualifier("inject that")
@Component
class Logic {
    void init() {
        System.out.println("finishing initialization " + this);
    }
}

//lookup
@Component
class ProjectComponent {
    @Resource(name = "logicList")
    List<Logic> lst;
    @Autowired
    Comparator<Integer> comparator;

    //@PostConstruct
    public void init() {
        System.out.println(lst);
    }
}