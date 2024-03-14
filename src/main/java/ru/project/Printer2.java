package ru.project;

import java.util.function.Consumer;

public class Printer2 implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println(model.res);
    }
}