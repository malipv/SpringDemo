package ru.project;

public class StartCorrect {
    public static void main(String[] args) {
        int x = new ObjectComposer("ru.project")
                .getObjectByNameAndType("+", PlusOperation.class).apply(2, 3);
        System.out.println(x);
    }
}