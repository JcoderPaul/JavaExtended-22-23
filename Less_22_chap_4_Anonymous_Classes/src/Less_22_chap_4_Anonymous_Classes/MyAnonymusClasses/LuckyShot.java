package Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses;

import java.util.Random;
/*
Простая игра 'Удачный выстрел'. Значение first - задает выстрел с упреждением,
second - диапазон от 0 до значения second в котором возникнет цель. Если проще,
то нужно просто заранее угадать цифру, случайно выпавшую в заранее заданном
диапазоне.
*/

/*
У нас есть конкретный класс с именем и мы видим что он имплементирует интерфейс и
реализует его метод. Самое главное - наличие имени у класса, т.е. он не анонимный, а
очень даже известный.
*/
public class LuckyShot implements MathOperation{
    Random rnd = new Random();
    @Override
    public int doOperation(int first, int second) {
        int i = rnd.nextInt(second);
        if(((first > second) || (first < 0))){
            System.out.print("Первое значение должно быть в пределах '0 - " + second + "' ошибка -> ");
            return -1;
        } else if (i == first){
            System.out.print("Вы меткий стрелок и попали в -> ");
            return i;
        } else {
            System.out.print("Вы промазали, нужно было палить в -> ");
            return i;
        }
    }
}