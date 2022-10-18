package Less_23_chap_1_Lambda;

import Less_23_chap_1_Lambda.MyOwnClasses.*;

public class Less_23_Lambda_Step2 {
    public static void main(String[] args) {
        // Для понимания реализуем анонимный класс и подсчитаем длину строки
        String str_for_length = "галлюцинации";
        System.out.print("Длинна слова '" + str_for_length + "' -> ");
        string_manipulation(str_for_length, new MyInterface() {
            @Override
            public int returnSomethingWhole(String str) {
                return str.length(); // Например, найдем длину строки
            }
        });
        /*
        Теперь реализация функционала через Lambda. На этот раз найдем количество вхождений
        одной буквы в слово (количество ее повторов)
        */
        String symbol_count_word = "обороноспособность";
        String find_symbol = "о";
        System.out.print("Теперь вы точно знаете сколько раз буква '" + find_symbol +
                         "' встречается в слове '" + symbol_count_word + "' -> ");

        string_manipulation(symbol_count_word,
                (str -> {return str.length() - str.replace(find_symbol, "").length();}));
        System.out.println(" !!! НО Я ГАРАНТИРУЮ, ВЫ НЕ ЗНАЕТЕ СЛОВО С 6-Ю буквами 'Ы' !!! ");

    }

    /*
    В текущем классе создали метод который на вход принимает некую строку и объект класса
    подписанного на функциональный интерфейс MyInterface. Как будет реализован метод
    'returnSomethingWhole' мы пока не придумали, но точно знаем, что он:
    - возвращает int;
    - принимает на вход строку;
    см. метод MAIN.
    */
    static void string_manipulation(String str, MyInterface myInterface){
        System.out.println(myInterface.returnSomethingWhole(str));
    }
}
