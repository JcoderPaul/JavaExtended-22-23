package Less_23_chap_2_LambdaSyntax;

import Less_23_chap_2_LambdaSyntax.MyOwnClasses.MyInterface;
import Less_23_chap_2_LambdaSyntax.MyOwnClasses.Student;

import java.util.ArrayList;
import java.util.List;

/*
Варианты написания Лямбда выражений, с выносом за пределы методов, где они могут использоваться.
*/
public class Less_23_chap_2_Lambda_Step4 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Цейхис",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Калибан",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Секвана",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Жорис",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Ринеция",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Тримир",'m',31,5,9.4));

        /*
        Если параметр один, то скобочки () можно опустить.
        В примере ниже, мы создали переменную, которой присвоили лямбду и теперь можем
        использовать ее несколько раз, в разных местах основного кода.
        */
        MyInterface check_student = student -> {if(student.age > 25) System.out.println(student);};
        // Печатаем всех студентов согласно условию в теле лямбды
        for (Student st_lst: stud_for_sorting) {
            // Используем ссылку на объект и запускаем метод описанный во внешнем Лямбда выражении
            check_student.checkStudent(st_lst);
        }
        // Если и тело лямбда выражения простое (однострочное), то и {} можно опустить
        MyInterface name_std_length = student -> System.out.println(student.name.length());
        name_std_length.checkStudent(stud_for_sorting.get(5)); // Узнаем длину имени студента с индексом 5
    }
}
