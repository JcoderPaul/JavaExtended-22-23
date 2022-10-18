package Less_23_chap_5_Consumer;

import Less_23_chap_5_Consumer.MyOwnClasses.Car;

import java.util.function.Consumer;

/*
Consumer<T> - ПОТРЕБИТЕЛЬ
Consumer<T> выполняет некоторое действие над объектом типа <T>, при этом ничего не возвращая.
*/
public class Less_23_Consumer_Step1 {
    public static void main(String[] args) {
        // Теперь у нас есть тащка_на_прокащку
        Car myOldCar = new Car("Волга 3111","Белый", 2.4);
        System.out.println(myOldCar);
        /*
        Используем статический метод 'pimpMyCar' и передаем в него наш объект для работы
        и лямбда выражение описывающее, манипуляции интерфейса ПОТРЕБИТЕЛЯ, т.е. функционал
        его метода *.accept()
        */
        pimpMyCar(myOldCar, car -> {
            car.setMadel("Волга Сайбер");
            car.setColor("Silver Metallic");
            car.setEngine_power(4.8);
            System.out.println("And now we have -> " + car);
        });
        System.out.println("------------------------------------------------------------------------");
        System.out.println(myOldCar);
    }
    /*
    Создаем статический метод pimpMyCar который ничего не возвращает, на вход принимает
    объект Car и Consumer. В теле метода мы обращаемся к методу *.accept() функционального
    интерфейса и отдаем в него нашу Car. Функционал самого метода *.accept() мы опишем
    в основном коде MAIN.
    */
    public static void pimpMyCar(Car car_for_pimp, Consumer<Car> myConsumer){
        myConsumer.accept(car_for_pimp);
    }
}
