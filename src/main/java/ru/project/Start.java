package ru.project;

public class Start {
    public static void main(String[] args) {
        int res = new ObjectComposer("target.classes.ru.project")
                .getObjectByNameAndType("+", PlusOperation.class).apply(2, 8);
        System.out.println('\n');
        System.out.println("Result = " + res);

        // после второго цикла в ObjectComposer строки ниже должны заработать
        //.getObjectByNameAndType("OperationMaker", OperationMaker.class)
        //.make()

    }
}