package Less_23_chap_4_LambdaSupplier;
/*
Supplier<T> - ПОСТАВЩИК, параметризированный функциональный интерфейс.
Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа <T>
*/
import Less_23_chap_4_LambdaSupplier.MyOwnClasses.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Less_23_Supplier_Step1 {
    public static void main(String[] args) {
        /*
        Заполняем "наш гараж" с использованием статического метода 'CarFactory', на вход ему
        мы передали способ реализации метода *.get() и количество машин, которые нужно создать.
        */
        List<Car> ourGarage = CarFactory(() ->
                new Car("Lada Kalina", "Red", 1.4),3);
        for (Car c_prn: ourGarage) {
            System.out.println(c_prn);
        }
        /*
        Естественно, как и раньше мы можем заранее создать ссылку на анонимный класс подписанный
        на Supplier и реализующий его метод. Например, создание параметров машин руками.
        */
        Supplier<Car> myCarFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите модель: ");
            String name = in.nextLine();
            System.out.println("Введите цвет: ");
            String color = in.nextLine();
            System.out.println("Введите мощность двигателя (через ','): ");
            Double power = in.nextDouble();
            Car handPainted = new Car(name, color, power);
            return handPainted;
        };

        List<Car> myHandMadeGarage = CarFactory(myCarFactory,3);

        for (Car c_prn: myHandMadeGarage) {
            System.out.println(c_prn);
        }
    }
    /*
    Статический метод 'фабрика машин' принимает на вход объект подписанный на интерфейс
    Supplier<Car> (Supplier<T>) и количество машин который нужно сделать. Сам метод
    CarFactory должен вернуть List<Car>. В теле метода мы создаем список, который будем
    в цикле заполнять машинами через метод *.get() интерфейса Supplier.
    */
    public static List<Car> CarFactory(Supplier<Car> carSupplier, int countOfCar){
        List<Car> carArr = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++){
            carArr.add(carSupplier.get());
        }
        return carArr;
    }
}
