package Less_22_chap_3_LocalInner_Classes.MyOwnClasses;
// Внешний класс
public class MyCalculation {
    private String name_of_outer_class = "Калькулятор";
    /* !!! Максимально инкапсулируем инкапсуляцию !!!
    Находясь во внешнем классе мы не можем обратиться к внутреннему классу обычным способом->
    -> Division div_res = new Division();
    Который создан внутри метода getResOfDivision, а значит переменные и методы класса Division недоступны.
    Однако обратный вариант возможен, т.е. внутренний локальный класс может оперировать переменными и методами
    внешнего класса (см.ниже).
    */

    // Методы внешнего класса MyCalculation
    private void prn_name_of_class(){
        System.out.println(name_of_outer_class);
    }
    public void getResOfDivision(int dividend, int divider){
        // ***** Локальный внутренний класс - его начало *****
        class Division{
            private int div = dividend; // Делимое - переменная (поле) локального внутреннего класса
            private int der = divider; // Делитель - переменная (поле) локального внутреннего класса
            // Частное от деления (целочисленный результат) - метод локального внутреннего класса
            private int getQuotientOfDivision(){
                if (der == 0){
                    System.out.print("На ноль тут делить нельзя, расчет не верен -> ");
                    return 0;
                } else {
                    return div / der;
                }
            }
            // Остаток от деления - метод локального внутреннего класса
            private int getModulo(){
                if (der == 0){
                    System.out.print("На ноль тут делить нельзя, расчет не верен -> ");
                    return 0;
                } else {
                    return div%der;
                }
            }
            private int getDiv() {
                return div;
            }
            private void setDiv(int div) {
                this.div = div;
            }
            private int getDer() {
                return der;
            }
            private void setDer(int der) {
                this.der = der;
            }
            // Внутренний локальный класс имеет доступ к данным внешнего класса, в отличие от второго
            private void getNameOfOuterClass(){
                System.out.print("Печать из метода внешнего класса его имени: ");
                prn_name_of_class();
                System.out.print("Печать переменной 'name_of_outer_class' внешнего класса: ");
                System.out.println(name_of_outer_class);
            }
        }
        // ***** Локальный внутренний класс - его конец *****


        /*
        !!! Применение внутреннего локального класса, внутри метода внешнего класса !!!
        Создаем объект внутреннего локального класса, внутри метода внешнего класса и
        используем его (внутреннего) методы (т.е. запускаем методы локального класса
        внутри метода внешнего класса)
        */
        Division division = new Division();
        System.out.println("Делимое -> " + division.getDiv());
        System.out.println("Делитель -> " + division.getDer());
        System.out.println("Частное -> " + division.getQuotientOfDivision());
        System.out.println("Остаток -> " + division.getModulo());
        System.out.println();
        division.getNameOfOuterClass();
    }
}
