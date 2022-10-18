package Less_22_chap_2_Inner_Classes;

import Less_22_chap_2_Inner_Classes.MyInnerClasses.MyBigCar;

public class Less_22_chap_2_Inner_Classes_Step1 {
    public static void main(String[] args) {
        /*
        Создается объект внешнего класса БольшаяМашина, и через конструктор создается
        объект внутреннего класса.
        */
        MyBigCar man_car = new MyBigCar("Black",2,2300);
        System.out.println(man_car);
        /*
        Создается объект внешнего класса БольшаяМашина, но пока без двигателя
        (движек, крутой, на заказ делаем отдельно). НО его все равно не сделать
        без объекта БольшаяМашина. И мы видим, что все очень похоже на первый
        вариант создания через конструктор, только часть кода ушла в конструктор.
        */
        MyBigCar scania_car = new MyBigCar("Red",3);
        // Машина без двигателя на экране
        System.out.println(scania_car);
        /*
        Делаем двигатель. ЕСЛИ ПРИГЛЯДЕТСЯ, то фактически, в этом примере 'scania_car'
        выполняет функцию 'this' в конструкторе, в схожих обстоятельствах. !!! Внутренний
        нестатический объект не может существовать без внешнего !!!
        */
        MyBigCar.DieselEngine cool_scania_engine = scania_car.new DieselEngine(3400);
        // Устанавливаем его в мишину, через сеттер
        scania_car.setEngine(cool_scania_engine);
        // Смотрим на машину с двигателем
        System.out.println(scania_car);
        // Снова машина без движка
        MyBigCar caterpillar_car = new MyBigCar("Ellow",4);
        System.out.println(caterpillar_car);
        // Создаем двигатель через другой сеттер
        caterpillar_car.setEnginePower(5600);
        // Снова смотрим на машину
        System.out.println(caterpillar_car);
//********************************* Неочевидный вариант создания внутреннего класса *****************************
        /*
        Правило создания внутреннего объекта осталось на месте -> сначала создается объект внешнего класса,
        и только после объект внутреннего класса (отсюда два 'new' подряд). Правда тут возникает казус,
        ссылки на наш новенький 'MyBigCar' отсутствует, хотя существует ссылка на новенький 'DieselEngine'
        */
        MyBigCar.DieselEngine new_engine_for_armata =
                new MyBigCar("DazzlePaint",3).new DieselEngine(6000);
        System.out.println(new_engine_for_armata +
                " и поршней там -> " + MyBigCar.DieselEngine.getCount_of_piston());
        /*
        !!! Из внутреннего класса мы можем вызвать private переменные внешнего класса (см. структуру классов)!!!
        */
        System.out.println("А дверей в нашей чудо машине -> " + new_engine_for_armata.getDoor_count());
    }
}
