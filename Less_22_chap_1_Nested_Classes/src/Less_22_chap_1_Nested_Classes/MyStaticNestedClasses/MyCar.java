package Less_22_chap_1_Nested_Classes.MyStaticNestedClasses;

public class MyCar {
    String color;
    int door_count;
    Engine engine;
    private static int count_of_filter = 8;

    public MyCar(String color, int door_count, Engine engine) {
        this.color = color;
        this.door_count = door_count;
        this.engine = engine;
    }
    /*
    Из внешнего класса мы легко можем обратиться к private переменным его внутреннего класса
    */
    public void getHorsePower(){
        Engine.count_of_piston = 14;
        int car_count_piston = Engine.count_of_piston;
        /*
        Создание объекта внутреннего класса внутри внешнего класса, естественно мы могли бы указать
        Car.Engine..., но мы уже внутри.
        */
        Engine inner_engine = new Engine(560);
        System.out.println(car_count_piston);
        System.out.println(inner_engine.horse_power);
    }

    @Override
    public String toString() {
        return "MyCar: {" +
                "color='" + color + '\'' +
                ", door_count=" + door_count +
                ", engine=" + engine +
                '}';
    }

    public static class Engine{
        private int horse_power;
        private static int count_of_piston = 6;

        public Engine(int horse_power) {
            this.horse_power = horse_power;
            // Обращаемся к статичной переменной внешнего класса, мы это можем т.к. наш класс тоже статичный
            System.out.println(count_of_filter);
            System.out.println(count_of_piston);
            /*
            Но мы не можем из статичного контекста обратится к нестатичной переменной например так ->
            ->  System.out.println(door_count);
            */
        }

        @Override
        public String toString() {
            return "MyEngine: {" +
                    "horse_power=" + horse_power +
                    '}';
        }
    }
}
