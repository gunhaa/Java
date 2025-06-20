package operator;

public class Operator {

    public static class Calculator {
        static int value;
    }

    public static void main(String[] args) {
        System.out.println("value = " +Calculator.value);
        System.out.println(Calculator.value++);
        System.out.println("value = " +Calculator.value);
        System.out.println(++Calculator.value);

        int a = 5;
        int b = 2;
        System.out.println("div1 = " + a/b);
        System.out.println("div2 = " + (double)a / b);
        System.out.println("div3 = " + a / (double) b);
        System.out.println("div4 = " + (float)a / b);
        System.out.println("div5 = " + a / (float) b);

    }
}
