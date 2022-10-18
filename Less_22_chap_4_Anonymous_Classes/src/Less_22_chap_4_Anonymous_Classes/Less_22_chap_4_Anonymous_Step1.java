package Less_22_chap_4_Anonymous_Classes;

import Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses.LogicalOperation;
import Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses.LuckyShot;
import Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses.MathOperation;

public class Less_22_chap_4_Anonymous_Step1 {
    public static void main(String[] args) {
        // В данном случае создается объект класса с именем, т.е. известный
        LuckyShot shot = new LuckyShot();
        int i = shot.doOperation(2,3);
        System.out.println(i);
//***********************************************************************************************************
        /*
        Мы не можем создавать объекты из интерфейсов !!! Но тут этого и не происходит, просто в данном
        случае кокой-то неизвестный (анонимный, безымянный, а не как в случае с LuckyShot) класс
        имплементирует интерфейс и реализует его единственный метод необходимым для данной задачи
        способом, подобные интерфейсы называют функциональными.
        */
        MathOperation m_sum = new MathOperation() {
            // Реализация метода под ссылку m_sum
            @Override
            public int doOperation(int first, int second) {
                return first + second;
            }
        }; // Не забываем ставить ';'
        System.out.println("Результат суммы: " + m_sum.doOperation(5,5));
        /*
        Причем реализация метода функционального интерфейса может быть сколь угодно сложной,
        да и сам класс может иметь очень широкий функционал, набор параметров и собственных методов.
        */
        MathOperation m_minus = new MathOperation() {
            // Реализация метода под ссылку m_minus
            @Override
            public int doOperation(int first, int second) {
                return first - second;
            }
        }; // Не забываем ставить ';'
        System.out.println("Результат разности: " + m_minus.doOperation(40,13));

//***********************************************************************************************************
        /*
        В данном случае можно сказать, что некий анонимный класс наследует от класса LogicalOperation
        и перезаписывает его метод compareVar с реализацией своего функционала. Т.е. не обязательно
        создавать функциональный интерфейс или абстрактный класс.
        */
        LogicalOperation lop_one = new LogicalOperation(){
            @Override
            public boolean compareVar(int limit, int...a) {
                int sum = 0;
                for (int i = 0; i < a.length; i++){
                    sum += a[i];
                }
                System.out.print(sum + " меньше предела " + limit + " -> ");
                return limit > sum;
            }
        }; // Не забываем ставить ';'
        System.out.println(lop_one.compareVar(24,2,4,5,8));

        LogicalOperation lop_two = new LogicalOperation(){
            @Override
            public boolean compareVar(int limit, int...a) {
                int multiplication = 1;
                for (int i = 0; i < a.length; i++){
                    multiplication *= a[i];
                }
                System.out.print(multiplication + " меньше предела " + limit + " -> ");
                return limit > multiplication;
            }
        }; // Не забываем ставить ';'
        System.out.println(lop_two.compareVar(240,2,4,5,8));
    }
}
