package operator;

public class Operator {

    public static class Calculator {
        static int value;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.value++);
        System.out.println(++Calculator.value);
    }
}
