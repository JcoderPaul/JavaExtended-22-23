package Less_23_chap_3_LambdaPredicate;

import Less_23_chap_3_LambdaPredicate.MyOwnClasses.Student;
import Less_23_chap_3_LambdaPredicate.MyOwnClasses.StudentInfoPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Less_23_Predicate_Negate_Step4 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Малкольм",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Таймус",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Секвана",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Жорис",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Ринеция",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Тримир",'m',23,5,9.4));
        stud_for_sorting.add(new Student("Алькимия",'f',27,2,7.4));
        stud_for_sorting.add(new Student("Санара",'f',23,2,7.4));

        StudentInfoPrint sip = new StudentInfoPrint();
        /*
        Вынесем наш анонимный класс за пределы метода 'choiceStdFromList' и пропишем условия работы метода
        'test' интерфейса Predicate и не забудем параметризовать его классом <Student>. Делаем две ссылки
        на предикат с разными условиями.
        */
        Predicate<Student> pred_1 = student -> student.avgGrade > 8; // Фильтруем по среднему балу > 8
        Predicate<Student> pred_2 = student -> student.sex == 'f'; // Фильтруем по полу
        // Смотрим по отдельности работу обоих прямых фильтров
        System.out.println("------------------------ Фильтр по среднему баллу ( > 8) ------------------------");
        sip.choiceStdFromList(stud_for_sorting, pred_1);
        System.out.println("------------------------ Фильтр по полу (только мадамы) ------------------------");
        sip.choiceStdFromList(stud_for_sorting, pred_2);
        /*
        Теперь перед нами стоит задача вывести нашу коллекцию (список) студентов с противоположными условиями,
        нежели pred_1 и pred_2. Что мы можем сделать? Мы можем изменить знак условия, создать новые предикатные
        ссылки с прописанными противоположными условиями. А можем использовать метод 'predicate.negate()',
        который разворачивает наши уже готовые условия с точностью до наоборот.
        */
        System.out.println("------------------------ Фильтр по среднему баллу ( < 8) ------------------------");
        sip.choiceStdFromList(stud_for_sorting, pred_1.negate());
        System.out.println("------------------------ Фильтр по полу (только жентельмены) ------------------------");
        sip.choiceStdFromList(stud_for_sorting, pred_2.negate());

    }
}
