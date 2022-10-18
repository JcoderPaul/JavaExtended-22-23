package Less_23_chap_1_Lambda;
/*
Более подробно, по шагам, как и зачем методики выборки элементов из коллекций, сначала превратились
в анонимные классы, а затем в элемент функционального программирования Lambda выражение рассмотрены
по адресу -> https://github.com/JcoderPaul/JavaBegin/tree/master/Less_29_myFirstLambda/src
*/
import Less_23_chap_1_Lambda.MyOwnClasses.*;

import java.util.ArrayList;
import java.util.List;

public class Less_23_Lambda_Step1 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Цейхис",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Калибан",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Секвана",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Жорис",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Ринеция",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Тримир",'m',31,5,9.4));
        StudentInfoPrint sip_first = new StudentInfoPrint();
        // Проверим метод печати, выведем на экран 3-го студента
        sip_first.printStdInf(stud_for_sorting.get(3));
        System.out.println("------------------------ Анонимный класс ------------------------");
        /*
        В данном случае мы уже явно прописываем условия по каким будут выбираться студенты из
        коллекции. Эти условия реализованы в методе, анонимного класса имплементирующего интерфейс
        'ForLambdaCheckStudent'. В текущем примере метод 'choiceStudent' принимает студента из
        коллекции и возвращает true, если возраст больше 23 (st_for_choice.age > 23) и естественно
        false если условие не выполнено.

        А теперь по шагам:
        1. Создается объект класса StudentInfoPrint (содержащий методы printStdInf и choiceStdFromList)
        2. Важный для нас метод имеет реализацию:
            public void choiceStdFromList(List<Student> stl, ForLambdaCheckStudent chs) {
                // Перебираем принятый на вход массив (коллекцию) в цикле.
                for (Student st_for_choice : stl) {
                    // Проводим отбор студента исходя из пока неизвестных условий.
                    // Неизвестность условий нужна для реализации универсальности этого отбора.
                    // Объект 'chs' активирует метод 'choiceStudent' получая на вход студента из списка.

                    // !!! И вот тут, в идеале, должен бы существовать класс в котором уже прописаны
                    // условия выбора подходящего студента из списка (проще, когда явно видишь реализацию
                    // метода) НО в нашем случае реализация метода происходит по месту приложения!!!
                    if (chs.choiceStudent(st_for_choice)) {
                        // Если студент удовлетворил условиям печатаем его
                        printStdInf(st_for_choice);
                    }
                }
            }
        3. Поскольку нам требуется универсальность и гибкость при выборе студентов из списка. Т.е.
           по любому параметру, по любому их сочетанию, по любому доступному нашей фантазии условию.
           !!! При этом код нашей программы позволяющий делать такую выборку должен быть максимально
           компактным без потери нужной функциональности (универсальности выбора)!!!

           ПОЭТОМУ

           Сам класс реализующий интерфейс 'ForLambdaCheckStudent' и реализация его метода 'choiceStudent',
           выбор необходимых условий фильтрации объектов из списка, прописывается по месту приложения см. ниже.
        */
        sip_first.choiceStdFromList(stud_for_sorting, new ForLambdaCheckStudent() {
            @Override
            public boolean choiceStudent(Student st_for_choice) {
                return st_for_choice.age > 23; // Фильтруем по возрасту
            }
        });

        sip_first.choiceStdFromList(stud_for_sorting, new ForLambdaCheckStudent() {
            @Override
            public boolean choiceStudent(Student st_for_choice) {
                return (st_for_choice.age > 23 && st_for_choice.sex =='m'); // Фильтруем по возрасту и полу
            }
        });
        /*
        Поскольку при реализации анонимного класса мы получили требуемое однообразие и минимальные
        отличия в реализации основного метода "фильтрации", то было применено синтаксическое упрощение
        кода Lambda-выражение.
        - В нашем примере мы знаем что возвращает наш метод (boolean), значит знаем,
          где этот результат можем применить;
        - Мы знаем, что метод получает на вход (Student st);
        - Мы знаем, какое условия (действие) хотим реализовать (например, {return st.age < 30});
        В итоге все выродилось в формулу: (входные параметры или их отсутствие) -> {... реализация метода ...}

        Мы не создаем отдельно набор реальных классов с именем, не подписываем их на интерфейс,
        не реализуем жестко фиксированным кодом метод интерфейса в каждом классе. Может нам этого
        и не надо, а может надо. Но мы экономим время и строки кода, реализуя требуемое в нужном
        месте, в отмеренном количестве.
        */
        System.out.println("------------------------ Лямбда выражение ------------------------");
        // Те же условия, что и выше, только короче.
        sip_first.choiceStdFromList(stud_for_sorting,
                      (Student st) -> {return st.age> 23;});
        sip_first.choiceStdFromList(stud_for_sorting,
                      (Student st_for_choice) -> {return (st_for_choice.age > 23 && st_for_choice.sex =='m');});
    }
}
