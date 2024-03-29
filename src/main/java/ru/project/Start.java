package ru.project;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ru.project");
    }
}

@Configuration
class Config {

    @Bean
    Logic logic2() {
        return new Logic();
    }

    @Bean
    List<Logic> logicList() {
        return List.of();
    }

    @Bean
    Comparator<Integer> comparator(Logic logic) {
        return (x, y) -> x - y;
    }
}

@Component
class Logic {
    void init() {
        System.out.println("finishing initialization " + this);
    }
}

//lookup
@Component
class ProjectComponent {
    @Autowired(required = false)
    List<Logic> lst;
    @Autowired
    Comparator<Integer> comparator;

    @PostConstruct
    public void init() {
        System.out.println(lst);
    }
}