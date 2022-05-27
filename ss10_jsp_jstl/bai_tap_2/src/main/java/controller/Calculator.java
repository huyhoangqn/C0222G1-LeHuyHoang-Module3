package controller;

public class Calculator {
    public static float cal(float first, float second, char operation) {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if (second != 0) {
                    return first / second;
                } else {
                    throw new RuntimeException("Can't divide");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
