package ru.project;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ru.project");

        // имена бинов - это имена классов, но с маленькой буквы
        //System.out.println(ctx.getBean("config"));
        //System.out.println(ctx.getBean("logic"));
/*
                ctx.getBean("operationMaker", OperationMaker.class)
                .make();
*/

        Logic logic1 = ctx.getBean("logic", Logic.class);
        Logic logic2 = ctx.getBean("logic", Logic.class);
        System.out.println(logic1 == logic2);

    }
}

/*
class MyScope implements org.springframework.beans.factory.config.Scope {

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        return null;
    }
}
*/

// настройка на java-config
// создание бина выполняется путём вызова метода, помеченного словом Bean, у класса, помеченного аннотацией Configuraion
@Configuration //- это тот же @Component
// фабрика бинов
class Config {

    Config(){
        System.out.println("Create Config");
    }

    @Bean /*@Lazy*/ //@DependsOn("logic")
        // фабричный метод
    Logic logic2() {
        System.out.println("Create logic from method");
        /*
        Logic ll = new Logic();
        System.out.println("created");
        //return new Logic();
        return ll;
        */
        return new Logic();
    }
}

// настройка на аннотациях
// вешаем на класс информацию, которая описывает, как объекты данного бина будут создаваться
// через вызов конструктора

@Component /*@Scope("singleton")*/ @Scope("prototype")
class Logic {
    Logic(){
        System.out.println("Create logic from class");
    }
    void init() {
        System.out.println("finishing initialization " + this);

    }
}

@Component @DependsOn("logic2")
class BLogic {
    BLogic(){
        System.out.println("Create logic from Bclass");
    }
    void init() {
        System.out.println("finishing initialization " + this);

    }
}