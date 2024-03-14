package ru.project;

import java.util.function.BinaryOperator;
@Component
public class MinusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x-y;
    }
}
