package Less_23_chap_6_LambdaFunction;

import Less_23_chap_6_LambdaFunction.MyOwnClasses.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Less_23_Interface_Function_Step1 {
    public static void main(String[] args) {
        List<Car> myCarCollection = new ArrayList<>();
        myCarCollection.add(new Car("Каддилак Гарибан","Желтый", 4.6, 5, 12));
        myCarCollection.add(new Car("Форд Аркада","Синий", 3.2,2,8));
        myCarCollection.add(new Car("Кенегсек Циклон","Зеленый", 6.6,2,18));
        myCarCollection.add(new Car("Лада Антарес","Оранжевый", 2.3,6,6));
        myCarCollection.add(new Car("УАЗ Скиф","Камуфляж", 5.2,5,12));
        /*
        В данном случае мы вместо объекта засылаем в метод 'averageOf' ламбда-выражение,
        описывающее, что нужно сделать с объектом Car, чтобы получить значение Double.
        В данном примере, просто взять значение объема двигателя для дальнейшего расчета.
        */
        double avg_engine_power = averageOf(myCarCollection, car -> car.getEngine_power());
        System.out.println(avg_engine_power);
        System.out.println("---------------------------------------------------------------------------");
        /*
        Как и раньше мы можем организовать ссылку на анонимный объект реализующий интерфейс Function
        */
        Function<Car, Double> outerFun = car -> {
            double i = car.getPiston_count();
            return i;
        };
        System.out.println(averageOf(myCarCollection,outerFun));
        /*
        И в первом, и во втором случае создавая Лямбда-выражение мы показывали, как должен работать
        метод *.apply() интерфейса Function, который мы используем в цикле метода 'averageOf'.
        */
    }
    /*
    Напишем метод averageOf, который возвращает double значение. У нашего класса Car есть три параметра:
    engine_power, door_count, piston_count. Обладая коллекцией каждого из них в отдельности, мы можем
    задумать найти среднее значение параметра.

    В нашем случае у нас есть коллекция машин и каждая обладает набором параметров. Допустим нам нужно
    найти среднее значение объемов двигателей, или среднее значение количества дверей в коллекции, или
    среднее количество поршней.

    Итак, на вход статического метода 'averageOf' попадают: коллекция автомобилей и объект подписанный
    на функциональный интерфейс 'Function'. У функционального интерфейса есть метод 'apply', который, в
    нашем случае получая на вход (в качестве аргумента) объект Car, должен вернуть Double.

    И вот с этим Double значением, что вернул метод *.apply(), уже дальше работает наш метод 'averageOf'.

    Но в нашем примере, в нашем методе, не раскрыта функциональность (код того, что будет реализовывать
    метод *.apply()) мы знаем только, что на входе будет Car результатом будет значение Double.
    Сама функциональность перезаписанного метода будет реализована в главном методе MAIN.

    */
    public static double averageOf(List<Car> car_collection, Function<Car, Double> fun){
        double avgRes = 0;
        for (Car car_for_find_avg: car_collection) {
            avgRes += fun.apply(car_for_find_avg);
        }
        avgRes = avgRes/car_collection.size();
        return avgRes;
    }
}
