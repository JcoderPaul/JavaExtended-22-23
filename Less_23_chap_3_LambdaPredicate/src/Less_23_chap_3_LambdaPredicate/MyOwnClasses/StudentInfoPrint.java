package Less_23_chap_3_LambdaPredicate.MyOwnClasses;

import java.util.List;
import java.util.function.Predicate;

public class StudentInfoPrint {
    /*
    Создаем метод который на вход получает наш массив студентов и переменную класса,
    имплементирующего интерфейс 'Predicate' параметризированный нами же <Student> и
    естественно, должны реализовать единственный его метод 'test', на данном этапе
    имеющий не очень понятную реализацию. Реализацию метода 'test' мы определим в
    основном коде. (параметризация важна, как всегда, что бы объяснить интерфейсу
    с чем придется работать)
    */
    public void choiceStdFromList(List<Student> stl, Predicate<Student> prd) {
        // Перебираем массив в цикле
        for (Student st_for_choice : stl) {
             // Проводим некий выбор студента исходя из пока неизвестных условий (см.основной код)
             if (prd.test(st_for_choice)) {
                 // Если студент удовлетворил условиям печатаем его
                 System.out.println(st_for_choice);
             }
        }
    }
}
