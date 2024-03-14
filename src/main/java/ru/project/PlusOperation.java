package ru.project;

import java.util.function.BinaryOperator;

public class PlusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x+y;
    }
}