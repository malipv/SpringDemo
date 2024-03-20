package ru.project;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;
@Component
public class Printer implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println(model.x + model.op + model.y + "=" + model.res);
    }
}