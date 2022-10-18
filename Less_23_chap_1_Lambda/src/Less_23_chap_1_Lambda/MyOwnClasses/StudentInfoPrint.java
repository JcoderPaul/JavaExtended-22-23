package Less_23_chap_1_Lambda.MyOwnClasses;

import java.util.List;

public class StudentInfoPrint {
    /*
    Метод для простой печати переменных выбранного студента (т.е. всех его данных),
    хотя мы могли просто реализовать метод *.toString() в самом классе Student,
    как вариант.
    */
    public void printStdInf(Student stud) {
        System.out.println("Имя студента: '" + stud.name +
                "' пол '" + stud.sex +
                "' возраст '" + stud.age +
                "' курс '" + stud.course +
                "' средняя оценка '" + stud.avgGrade + "'");
    }
    /*
    Создаем метод который на вход получает наш массив студентов и переменную класса,
    имплементирующего интерфейс 'ForLambdaCheckStudent' и естественно, реализующий
    единственный его метод 'choiceStudent(Student st)', на данном этапе имеющий не
    очень понятную реализацию.

    Но поскольку название метода содержит слово 'choice', то скорее всего это некий
    выбор подходя(щего/щих) студент(а/ов) из загруженного списка студентов. Т.е.
    реализация метода 'choiceStudent(Student st)' предполагает некий выбор. А он
    огромен, это как минимум 5-ть переменных класса Student и еще большее их сочетание.
    */
    public void choiceStdFromList(List<Student> stl, ForLambdaCheckStudent chs) {
        // Перебираем массив в цикле
        for (Student st_for_choice : stl) {
             // Проводим некий выбор студента исходя из пока неизвестных условий (см.основной код)
             if (chs.choiceStudent(st_for_choice)) {
                 // Если студент удовлетворил условиям печатаем его
                 printStdInf(st_for_choice);
             }
        }
    }
}
