package Less_23_chap_1_Lambda;

import Less_23_chap_1_Lambda.MyOwnClasses.MyInterface;

public class Less_23_Lambda_Step3 {
    public static void main(String[] args) {
        /*
        Вот такой код сложен для моего понимания, однако попробую разложить:
        1. У нас есть статический метод string_manipulation(MyInterface myInterface);
        2. Который принимает на вход !!! объект класса подписанного на интерфейс MyInterface !!!;
        3. А значит и на все его методы и их реализации;
        4. И мы даем методу 'string_manipulation' на вход анонимный класс подписанный на MyInterface;
        5. И реализуем метод этого интерфейса 'returnSomethingWhole'
           (например, находим длину заранее заданной строки);
        */
        System.out.println("-------------- Анонимный класс --------------");
        string_manipulation(new MyInterface() {
            @Override
            public int returnSomethingWhole(String str) {
                return str.length();
            }
        });
        System.out.println("-------------- Лямбда выражение --------------");
        /*
        И тут срабатывает магия Lambda - "коротко, загадочно и непонятно"
        Вместо объекта, мы закинули в статический метод реализацию метода
        этого объекта, и конечно 'под броней' Java намутит все, как надо,
        но бог ты мой ...
        !!! Я пишу это для себя, практика, практика и еще раз практика !!!
        */
        string_manipulation((String str) -> {return str.length();});
    }

    /*
    В текущем классе создали метод который на вход принимает некую строку и объект класса
    подписанного на функциональный интерфейс MyInterface. Как будет реализован метод
    'returnSomethingWhole' мы пока не придумали, но точно знаем, что он:
    - возвращает int;
    - принимает на вход строку;
    см. метод MAIN.

    В данном случае функционал несколько подрезан в отличие от примера Less_23_Lambda_Step2,
    поскольку слово, с которым происходит работа, прописывается тут.
    */
    static void string_manipulation(MyInterface myInterface){
        /*
        !!! Тонкий момент !!!
        Мы выводим на экран результаты метода 'returnSomethingWhole', который принял на вход
        строку, но чего с ней делать неясно. Т.е. результат нужен, но его пока нет, см. MAIN.
        */
        System.out.println(myInterface.returnSomethingWhole("трагедия"));
    }
}
