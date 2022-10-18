package Less_22_chap_3_LocalInner_Classes;

import Less_22_chap_3_LocalInner_Classes.MyOwnClasses.MyCalculation;
import Less_22_chap_3_LocalInner_Classes.MyOwnClasses.SimpleMathOperation;

public class Less_22_LocalInner_Classes_Step1 {
    public static void main(String[] args) {
        MyCalculation rascet = new MyCalculation();
        rascet.getResOfDivision(45,3);

        /*
        Теперь немного об анонимных классах, это еще не они, но уже близко (и пахнет Лямбдой).
        Тут мы имеем внутренний локальный класс Addition подписанный на интерфейс SimpleMathOperation.
        Далее идет создание объект от этого класса и использование единственного метода.
        */
        class Addition implements SimpleMathOperation{
            @Override
            public int doOperation(int first_var, int second_var) {
                return first_var + second_var;
            }
        }

        Addition my_sum = new Addition();
        System.out.println(my_sum.doOperation(34, 66));
    }
}
