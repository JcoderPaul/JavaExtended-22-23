package Less_23_chap_3_LambdaPredicate;

import Less_23_chap_3_LambdaPredicate.MyOwnClasses.*;
/*
Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
Если оно соблюдается, то возвращается значение true. В качестве параметра
лямбда-выражение принимает объект типа T.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Less_23_Lambda_Predicate_Step1 {
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
        Все работает как с нашим самописным функциональным интерфейсом, но в данном случае
        мы используем возможности встроенного пакета java.util и его функциональных интерфейсов.
        В нашем случае используется параметризированный функциональный интерфейс Pradicate.
        */
        sip.choiceStdFromList(stud_for_sorting, student -> student.age >= 23);
        System.out.println("---------------------------------------------------------------------------");
        /*
        Вынесем наш анонимный класс за пределы метода 'choiceStdFromList' и пропишем условия работы метода
        'test' интерфейса Predicate и не забудем параметризовать его классом <Student>
        */
        Predicate<Student> choice_avg_grade_and_course = (student_for_choice) ->
                    {return student_for_choice.avgGrade > 6 && student_for_choice.course > 3;};
        sip.choiceStdFromList(stud_for_sorting, choice_avg_grade_and_course);

    }
}
