package ru.project;

public class Start {
    public static void main(String[] args) {
        //int x = new ObjectComposer("ru.project")
        //int x = new ObjectComposer("C:\\Users\\Tanya\\IdeaProjects\\SpringDemo\\target\\classes\\ru\\project")

        int x = new ObjectComposer("src.main.java.ru.project")
                .getObjectByNameAndType("+", PlusOperation.class).apply(2, 3);
    }
}