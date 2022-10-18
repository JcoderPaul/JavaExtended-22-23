package Less_23_chap_2_LambdaSyntax;
/*
Интерфейс с пустыми параметрами
*/
import Less_23_chap_2_LambdaSyntax.MyOwnClasses.*;

public class Less_23_chap_2_Lambda_Step5 {

    static int g = 67;
    static double k = 58;

    public static void main(String[] args) {
        // Немного надуманный пример, но я учусь, как говорил мой математик, "до щелчка"!
        int a = 45;
        double b = 23.4;
        System.out.println("-----------------------------------------------------");
        MyСalculations calcSum = () -> System.out.println(a + b);
        calcSum.doCalculations();
        System.out.println("-----------------------------------------------------");
        MyСalculations calcMinus = () -> System.out.println(a - b);
        calcMinus.doCalculations();
        System.out.println("-----------------------------------------------------");
        MyСalculations calcSum_2 = () -> {g = 100; k = 200; System.out.println(g + k);};
        calcSum_2.doCalculations();
        System.out.println(g);
        System.out.println(k);

    }
}
