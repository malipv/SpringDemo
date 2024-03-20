package ru.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("ru.project")
                .getBean("operationMaker", OperationMaker.class)
                .make();

        // после второго цикла в ObjectComposer строки ниже должны заработать
        //.getObjectByNameAndType("OperationMaker", OperationMaker.class)
        //.make()

    }
}