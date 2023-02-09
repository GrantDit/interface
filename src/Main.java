import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("Задание 1");
        Predicate<Integer> positiveNumber = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 0;
            }
        };
        System.out.println(positiveNumber.test(2));
        System.out.println(positiveNumber.test(-2));
        Predicate<Integer> positiveNumberLambda = number -> number > 0;
        System.out.println(positiveNumberLambda.test(2));
        System.out.println(positiveNumberLambda.test(-2));

        //Задание 2
        System.out.println("Задание 2");
        Consumer<String> name1 = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.printf("Привет, " + name);
            }
        };
        name1.accept("Кирилл");
        System.out.println();
        Consumer<String> nameLambda = name2 -> System.out.println("Привет, " + name2);
        nameLambda.accept("Ксения");
        //Задание 3
        System.out.println("Задание 3");

        Function<Double,Long> numberLong = new Function<Double,Long>() {
            @Override
            public Long apply(Double number) {
                return Math.round(number);
            }
        };
        System.out.println(numberLong.apply(23.6));
        System.out.println();
        Function<Double, Long> numberLongLambda = number -> Math.round(number);
        System.out.println(numberLongLambda.apply(23.4));

        //Задание 4
        System.out.println("Задание 4");
        Supplier<Integer> randomNumber = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random randomNumber = new Random();
                return randomNumber.nextInt(100);
            }
        };
        System.out.println(randomNumber.get());
        Supplier<Integer> randomNumber1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(randomNumber1.get());
        System.out.println();
        //Задание 5

        System.out.println("Задание 5");
        Function<Integer, Integer> method1 = x -> x * 2;
        Function<Integer, Integer> method2 = x -> x / 2;
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        Function<Integer, Integer> checkResult = ternaryOperator(isOdd, method1, method2);
        checkResult.apply(6);
        checkResult.apply(2);
        checkResult.apply(23);
        checkResult.apply(57);
        checkResult.apply(6);
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            U checkResult = condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
            System.out.println(checkResult);
            return checkResult;
        };
    }
}

