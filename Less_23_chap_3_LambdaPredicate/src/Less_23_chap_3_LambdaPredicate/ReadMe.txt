В JDK 8 вместе с самой функциональностью лямбда-выражений также было добавлено некоторое количество
встроенных функциональных интерфейсов, которые мы можем использовать в различных ситуациях и в
различные API в рамках JDK 8. В частности, ряд далее рассматриваемых интерфейсов широко применяется
в Stream API - новом прикладном интерфейсе для работы с данными.
Основные из этих интерфейсов:
- Predicate<T>
- Consumer<T>
- Function<T,R>
- Supplier<T>
- UnaryOperator<T>
- BinaryOperator<T>

*** Predicate<T> ***
Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия. Если оно соблюдается,
то возвращается значение true. В качестве параметра лямбда-выражение принимает объект типа T:

public interface Predicate<T> {
    boolean test(T t);
}
Например:
---------------------------------------------------------------------------------------------------------
import java.util.function.Predicate;

public class PredicateLambdaApp {

    public static void main(String[] args) {

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }
}