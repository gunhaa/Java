package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> {
            return Math.random();
        };

        System.out.println(supplier.get());

        Consumer<String> consumer = (s) -> System.out.println("출력: " + s);
        consumer.accept("인자를 받고 출력을 안하는 인터페이스임");

        Function<String, Integer> strLength = s -> {
            System.out.println(s);
            return s.length();
        };

        Integer res = strLength.apply("람다");
        System.out.println("Function 인터페이스의 결과: " + res);

        Predicate<Integer> isEven = n -> {
            return n % 2 == 0;
        };

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7)); // false
    }
}
