package ru.project;

public class StartCorrect {
    public static void main(String[] args) {
        /*
        OperationMaker operationMaker = new OperationMaker();
        operationMaker.datareader = new DataReader();
        operationMaker.operations.put("+", new PlusOperation());
        operationMaker.operations.put("-", new MinusOperation());
        operationMaker.printer = new Printer2();
        operationMaker.printer = new Printer();
        operationMaker.make();
        */

        new ObjectComposer("ru.project")
                .getObjectByNameAndType("OperationMaker", OperationMaker.class)
                .make();
    }
}