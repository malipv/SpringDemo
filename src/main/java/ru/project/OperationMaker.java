package ru.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class OperationMaker {

    @Autowired Supplier<Model> datareader;
    @Autowired Consumer<Model> printer;
    @Autowired Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public void make() {
        Model model = datareader.get();
        model.res = operations
                .get(model.op)
                .apply(model.x, model.y);
        printer.accept(model);
    }
}