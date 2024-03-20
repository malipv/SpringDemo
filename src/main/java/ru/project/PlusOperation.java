package ru.project;

import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

@Component("+")
public class PlusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x + y;
    }
}