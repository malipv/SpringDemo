package ru.project;

import java.util.Scanner;
import java.util.function.Supplier;
@Component
public class DataReader implements Supplier<Model> {
    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);
        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();
        return model;
    }
}
