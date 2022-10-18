package Less_23_chap_5_Consumer;

import Less_23_chap_5_Consumer.MyOwnClasses.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Less_23_Consumer_ForEach_Step2 {
    public static void main(String[] args) {
        List<Car> myCarCollection = new ArrayList<>();
        myCarCollection.add(new Car("Каддилак Гарибан","Желтый", 4.6));
        myCarCollection.add(new Car("Форд Аркада","Синий", 3.2));
        myCarCollection.add(new Car("Кенегсек Циклон","Зеленый", 6.6));
        // Мы можем вывести на печать наши машины через (вспомним):
        System.out.println("------ Классический FOR ------");
        for (int i = 0; i < myCarCollection.size(); i++){
            System.out.println(myCarCollection.get(i));
        }
        System.out.println("------ Неоклассический FOREACH ------");
        for (Car car_prn: myCarCollection){
            System.out.println(car_prn);
        }
        System.out.println("------ Классический ITERATOR ------");
        Iterator<Car> car_iter = myCarCollection.listIterator();
        while (car_iter.hasNext()){
            System.out.println(car_iter.next());
        }
//******************************** FOREACH CONSUMER ********************************
        // Интерфейс Consumer предоставляет новые возможности по работе с циклами
        System.out.println("------ FOREACH CONSUMER ------");
        myCarCollection.forEach(car -> System.out.println(car));
        // Если действие одно и на печать, то можно получить еще более короткую запись
        myCarCollection.forEach(System.out::println);
        System.out.println("---------------------------------------------------");
//**********************************************************************************
        List<Integer> myIntList = List.of(23,345,6,23,6,8,0,-12,34,-5);
        myIntList.forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n---------------------------------------------------");
        myIntList.forEach(integer -> {
            System.out.println("Неизмененный элемент -> " + integer + " ");
            integer *= 2;
            System.out.println("После умножения на 2 -> " + integer + " ");
        });
        System.out.println("---------------------------------------------------");
        /*
        Так называемый ссылочный метод (Method References)
        Если лямбда выражения вызывают только один существующий метод, лучше ссылать на этот метод
        по его имени. Ссылки на методы (Method References) – это компактные лямбда выражения для
        методов у которых уже есть имя.
        Например:
        => Consumer<String> consumer = str -> System.out.println(str);
        можно переписать с помощью method references:
        => Consumer<String> consumer = System.out::println;
        */
        myIntList.forEach(System.out::println);
    }
}
