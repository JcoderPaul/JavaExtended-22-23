- См. док. [The Java™ Tutorials - Local Classes (from ORACLE)](https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html)

---
### Локальный внутренний класс (Local Inner Class)

Локальный класс — это вложенный класс, объявленный внутри другого класса или некоторого блока кода этого класса, 
то есть объявленный между фигурными скобками {}. Этот блок может быть статическим блоком, циклом, телом if и т.д.

Можно объявить вложенный класс внутри блока кода, например метода, конструктора или блока инициализации. Он будет 
называться локальным вложенным классом. Чаще всего локальные классы объявляются внутри тела метода.

Локальный класс объявленный внутри блока кода другого класса не является членом класса, к которому относится блок, 
а принадлежит самому блоку, точно так же, как обычная локальная переменная. Такие классы недоступны за пределами 
внешнего класса, поскольку нет никаких способов обращения к ним, но их экземпляры – это обычные объекты, которые 
позволяется, например, передавать в качестве аргументов или возвращать из методов.

Время жизни локального внутреннего класса, это время пока существует хотя бы одна ссылка на него.
Такой класс существует внутри блока кода и время его жизни ограниченно этим блоком.

Единственный модификатор, который допускается применять в объявлении локального класса – это final, предотвращающий, 
как обычно, возможность расширения класса. Члены локального класса могут быть объявлены, как закрытыми, так и открытыми. 
К ним применяются модификаторы, которые применимы к обычному классу.

Например:

```java
package MyLocalClasses;

public class OuterStaticInit {
     static
     {
         class LocalInit{
            LocalInit(){
                 System.out.println("From static iniz");
            }
         }
         LocalInit localInit = new LocalInit();
         System.exit(0);
     }

     public static void main(String[] args) {
        System.out.println("From main");
     }
}
```

**!!! Локальный класс – это класс, объявленный в блоке Java кода !!!**

Поскольку все блоки Java кода находятся внутри определения класса, то все локальные классы вложены в окружающие классы. 
К локальному классу применяются правила обычной локальной переменной. Область видимости такого класса — это область 
видимости окружающего его блока.

**Свойства локального класса:**
- Подобно вложенным нестатическим классам, локальные классы связаны с окружающим экземпляром и имеют доступ ко всем членам, включая private члены окружающего класса.
- Локальный класс нельзя объявить с каким-либо модификатором доступа, кроме как static final.

Поскольку, модификаторы доступа для членов класса мы можем применять только к членам класса.
Эти модификаторы не доступны для объявления локальных переменных или классов, находящихся в
блоке и не являющиеся членами класса.

**Как и нестатические вложенные классы, и по тем же причинам, локальные классы не могут иметь static поля, 
исключение составляют константы, объявленные как static final.**

**Применение:**
Основное применение локальные классы находят в тех случаях, когда необходимо написать класс, который будет
использоваться внутри одного метода. Создание локального класса – способ не загромождать пространство имен.

Если класс определяется в теле метода, то его называют локальным внутренним классом.

Пример доступа к переменным внешнего класса из локального внутреннего класса:

```java
package LocalClasses;

public class LocalClassAndVars {
     private int prIntVar = 1;
     private static int prStIntVar = 2;
     private final int prFinVar  = 3;

     LocalClassAndVars(){ }

     void anyMethodOfOuter(){
         class LocalClass{
           void anyMethodLocal(){
              prIntVar = 10;
              prStIntVar = 20;
              /** prFinVar  = 30; финальная нельзя менять, но мы можем прочитать **/
              int localVar = prFinVar;
           }
         }
       LocalClass localOb = new LocalClass();
       localOb.anyMethodLocal();
     }

     public static void main(String[] args) {

         LocalClassAndVars   outerObj = new LocalClassAndVars();
         System.out.println("prIntVar = "+ outerObj.prIntVar + " prStIntVar = "+ LocalClassAndVars.prStIntVar
         + " prFinVar = "+ outerObj.prFinVar);

         outerObj.anyMethodOfOuter();

         System.out.println("prIntVar = "+ outerObj.prIntVar + " prStIntVar = "+ LocalClassAndVars.prStIntVar
         +" prFinVar = "+ outerObj.prFinVar);

    }
}
```

Цитата из книги **"Effective Java TM. Programming Language Guide." - Joshua Bloch**:

```
«Локальный класс можно декларировать везде, где разрешается декларировать локальную переменную,
и он подчиняется тем же самым правилам видимости. Локальный класс имеет несколько признаков,
объединяющих его с каждой из трех других категорий вложенных классов. Как и классы-члены, локальные
классы имеют имена и могут использоваться многократно. Как и анонимные классы, они имеют окружающий
их экземпляр тогда и только тогда, когда применяются в нестатическом контексте. Как и анонимные
классы, они должны быть достаточно короткими, чтобы не мешать удобству чтения метода или инициализатора,
в котором они содержатся»
```

---
#### Выжимка:

1. Локальные классы определяются в блоке кода и область их видимости — этот блок кода. Объекты локального класса могут создаваться в блоке кода, котором они описаны.

2. Локальные классы не имеют модификаторов доступа private или public, потому что они принадлежат не классу, а тому блоку кода, в котором они описаны.

3. Локальные классы, объявленные в статичном блоке, могут обращаться только к статичным полям внешнего класса.

4. Локальные классы могут иметь модификаторы доступа final.

5. Локальные классы не могут быть статичными, за исключением static final.

6. В java8 мы можем обращаться из локального класса не только к финальным переменным внешнего класса, но и к не финальным методам внешнего класса, если они не были изменены до момента инициализации класса.

7. Локальные классы имеют доступ к закрытым переменным внешнего класса, в контексте экземпляра. То есть локальные классы ведут себя в этом отношении как внутренние классы.

---
**Доп. материал:**
- [The Java™ Tutorials - Nested Classes **(from ORACLE)**](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
- [Java Inner Class and its 4 Types You Must Know About! **(from techvidvan.com)**](https://techvidvan.com/tutorials/java-inner-class/)
- [Java Program to illustrates Use of Static Inner Class **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/java-program-to-illustrates-use-of-static-inner-class/)
- [Java Program to Check if a Given Class is a Local Inner Class **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/java-program-to-check-if-a-given-class-is-a-local-inner-class/)
- [Local Inner Class in Java **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/local-inner-class-java/)
- [Java Local Inner Class](https://www.tpointtech.com/local-inner-class)
- [Local Inner Class In Java](https://javaconceptoftheday.com/local-inner-class-in-java/)
- [What is the difference between an inner class and a local inner class in java?](https://stackoverflow.com/questions/10392725/what-is-the-difference-between-an-inner-class-and-a-local-inner-class-in-java)
- [Inner Class](https://jtcindia.org/tutorials/java/inner-class.php)
- [Local Inner Classes Example in Java](https://dineshonjava.com/local-inner-classes-example-in-java/)
- [Inner classes in java: Anonymous inner and static nested class](https://beginnersbook.com/2013/05/inner-class/)
- [Java Inner Classes](https://iqratechnology.com/academy/java/java-basic/java-inner-classes/)
- [Nested Class in Java](https://www.scaler.com/topics/what-is-nested-class-in-java/)
- [Method Local Inner Class in Java **(from Scientech Easy)**](https://www.scientecheasy.com/2020/06/method-local-inner-class-in-java.html/)
- [Method Local Inner Classes in Java](https://cs-fundamentals.com/java-programming/java-method-local-inner-classes)
