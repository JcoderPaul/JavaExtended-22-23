package Less_23_chap_2_LambdaSyntax;
/*
Лямбда выражение в Comparator-е, сортируем без подписи на интерфейс Comparable
*/
import Less_23_chap_2_LambdaSyntax.MyOwnClasses.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Less_23_chap_2_Lambda_Step6 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Цейхис",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Калибан",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Секвана",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Жорис",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Ринеция",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Тримир",'m',23,5,9.4));
        stud_for_sorting.add(new Student("Алькимия",'f',27,2,7.4));
        stud_for_sorting.add(new Student("Санара",'f',23,2,7.4));
        // Сортировка по имени (естественная)
        Collections.sort(stud_for_sorting,(st1, st2) -> st1.name.compareTo(st2.name));
        System.out.println("----------- Сортировка по имени Лямбда -----------");
        for (Student st_prn: stud_for_sorting) {
            System.out.println(st_prn);
        }
        System.out.println("----------- Сортировка по полу и имени анонимный класс -----------");
        // Можем вынести за границы метода с созданием анонимного класса
        Comparator <Student> comparator_sex_name = new Comparator<>() {
            @Override
            public int compare(Student student_1, Student student_2) {
                int res = student_1.name.compareTo(student_2.name);
                if (student_1.sex == student_2.sex) {
                    return res;
                } else if (student_1.sex > student_2.sex) {
                    return +1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(stud_for_sorting, comparator_sex_name);
        for (Student st_for_prn: stud_for_sorting) {
            System.out.println(st_for_prn);
        }
        System.out.println("----------- Сортировка по возрасту и имени Лямбда -----------");
        // Можем вынести за границы метода с созданием Лямбды
        Comparator <Student> comparator_age_name = (Student student_one, Student student_two) -> {
                int res = student_one.name.compareTo(student_two.name);
                if (student_one.age == student_two.age) {
                    return res;
                } else if (student_one.age > student_two.age) {
                    return +1;
                } else {
                    return -1;
                }
        };
        Collections.sort(stud_for_sorting, comparator_age_name);
        for (Student st_for_prn: stud_for_sorting) {
            System.out.println(st_for_prn);
        }
    }
}
