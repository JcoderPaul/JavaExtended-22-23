package Less_22_chap_1_Nested_Classes;
/*
Просто создаем и тестируем (напоминаем себе) вложенные классы, в данном случае статические, что
позволяем создавать объекты этого класса без создания объекта класса в который он вложен, т.е.
поведение этого класса, в принципе, похоже на поведение обычного класса.
*/
import Less_22_chap_1_Nested_Classes.MyStaticNestedClasses.MyCar;

public class Less_22_Nested_Classes_Step1 {
    public static void main(String[] args) {
        /*
        Попробуем создать наш двигатель, в отличие от классических классов, данный
        класс вложенный, но статичный и публичный, что несколько упрощает жизнь.
        */
        MyCar.Engine my_nested_engine = new MyCar.Engine(320);
        System.out.println(my_nested_engine);
        MyCar my_car_with_nested_engine = new MyCar("Red", 2, my_nested_engine);
        System.out.println(my_car_with_nested_engine);
        MyCar my_car_with_nested_engine_two = new MyCar("Black", 4, new MyCar.Engine(450));
        System.out.println(my_car_with_nested_engine_two);
        my_car_with_nested_engine.getHorsePower();

    }
}
