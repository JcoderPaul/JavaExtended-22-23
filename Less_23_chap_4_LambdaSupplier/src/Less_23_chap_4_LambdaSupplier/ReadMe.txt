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

*** Supplier<T> ***
Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:

public interface Supplier<T> {
    T get();
}

Например:
--------------------------------------------------------------------------------------------------------
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierLambdaApp {

    public static void main(String[] args) {

        Supplier<User> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }
}

// *** Наш класс для работы с интерфейсом Supplier ***
class User{
    private String name;

    User(String n){
        this.name=n;
    }

    String getName(){
        return name;
    }
}
--------------------------------------------------------------------------------------------------------