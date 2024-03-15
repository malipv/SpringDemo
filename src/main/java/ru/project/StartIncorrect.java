package ru.project;

// некорректная реализация SOLID

import java.util.Scanner;

public class StartIncorrect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        switch (operation) {
            case "+": res = x + y; break;
            case "-": res = x - y; break;
            case "*": res = x * y; break;
            case "/": res = x / y; break;
        }
        System.out.println(x+operation+y+"="+res);
    }
}