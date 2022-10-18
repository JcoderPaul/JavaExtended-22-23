package Less_22_chap_2_Inner_Classes.MyInnerClasses;
/*
Теперь наш внутренний класс нестатичный и его поведение немного другое.
Создать его мы можем только внутри его внешнего класса (например в конструкторе см. ниже).

!!! В Ставке Гитлера ходят упорные слухи, что некоторых советских соколов некоторые
несознательные механики перед боевым вылетом крестят... Ах, да! Ходят упорные слухи,
что в старых версиях JAVA, во внутреннем НЕстатическом классе не может быть статических
переменных !!!
*/
public class MyBigCar {
    private String color;
    private int door_count;
    private DieselEngine engine;
    /*
    Внесем изменения в конструктор, вместо ссылки на объект дизельный двигатель, мы сразу
    задаем его мощность, а в теле конструктора создаем объект с указанным параметром.
    Помним, что this - обозначает текущий объект (действия с текущим объектом)
    */
    public MyBigCar(String color, int door_count, int horse_power) {
        this.color = color;
        this.door_count = door_count;
        /*
        Мы обращаемся к текущему объекту MyBigCar, а через точку "." указываем к какому полю
        или методу (пока все привычно). Далее мы ссылаемся на вновь созданный внутренний объект,
        принадлежащий внешнему объекту, но что указывает "." и передаем во внутренний объект
        аргумент из внешнего списка аргументов.

        Т.е. для создания объекта внутреннего класса нужен объект внешнего класса, а это в
        конструкторе this (т.е. намек на то, что внешний класс уже создан)

        Если подумать, то это похоже на работу старого конструктора, когда в него аргументом
        залетала ссылка на (внешний) объект двигатель (см.ниже).
        */
        this.engine = this.new DieselEngine(horse_power);
    }
    /*
    Старый вариант конструктора, который будет работать для static DieselEngine
    (но не для текущего варианта этого класса)

    public MyBigCar(String color, int door_count, DieselEngine engine) {
        this.color = color;
        this.door_count = door_count;
        this.engine = engine;
    }
    */

    public MyBigCar(String color, int door_count) {
        this.color = color;
        this.door_count = door_count;
    }

    public void setEngine(DieselEngine engine) {
        this.engine = engine;
    }

    public void setEnginePower(int horse_power) {
        this.engine = this.new DieselEngine(horse_power);
    }

    @Override
    public String toString() {
        return "MyBigCar => {" +
                "color='" + color + '\'' +
                ", door_count=" + door_count +
                ", engine=" + engine +
                '}';
    }

    public class DieselEngine{
        private int horse_power;
        private static int count_of_piston = 12;

        public DieselEngine(int horse_power) {
            this.horse_power = horse_power;
        }
        /*
        !!! Из внутреннего класса мы можем вызвать private переменные внешнего класса !!!
        */
        public int getDoor_count() {
            return door_count;
        }

        public static int getCount_of_piston() {
            return count_of_piston;
        }

        @Override
        public String toString() {
            return "DieselEngine => {" +
                    "horse_power=" + horse_power +
                    '}';
        }
    }
}
