package Less_23_chap_3_LambdaPredicate;

import Less_23_chap_3_LambdaPredicate.MyOwnClasses.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Less_23_Predicate_removeIf_Step2 {
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
        Collections.sort(stud_for_sorting, (st_1, st_2) -> st_1.age - st_2.age);
        Iterator<Student> my_iter = stud_for_sorting.listIterator();
        while (my_iter.hasNext()){
            System.out.println(my_iter.next());
        }
        System.out.println("--------------------------------------------------------------------------");
        /*
        Удаляем из коллекции элементы по условию. Метод removeIf в своей работе использует интерфейс
        'Predicate' и реализует его метод 'test', через который проходят все элементы коллекции по
        одиночке, а условия тестирования (или удаления) каждого элемента коллекции мы прописываем сами.
        */
        stud_for_sorting.removeIf(i -> (i.age > 21 && i.age < 27));
        for (Student st_prn: stud_for_sorting) {
            System.out.println(st_prn);
        }
    }
}
