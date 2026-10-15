- См. док. (ENG): [Anonymous Classes (from The Java™ Tutorials by ORACLE)](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)

---
### Анонимные классы

Анонимным классом называется класс, в котором программист не задает явно имя экземпляру.

Простой пример: `new MyClass();` т.е. нет классического `MyClass my_class =`

В анонимном классе явно не задается конструктор класса, а используется конструктор базового класса.
Мы можем создать анонимный класс, передав некоторое значение в конструктор базового класса.

```
    new MyClass(80);
```

---
#### Случаи применения

Анонимные классы применяются там, где вам необходим функционал анонимного класса без повторного использования (КЛАСС НА РАЗ). 
При повторном использовании функционала анонимного класса есть смысл создать отдельный класс.

Добавить новый функционал анонимному классу можно так: 

```
    new MyClass(){ // Тело нового анонимного класса. Новый функционал нашего класса };
```

Точка с запятой, означает не только окончание класса, а окончание блока кода. Пример (работает некорректно, см. ниже):

```java
    public class MyFutureAnonymousClass {
    
        public static void main(String[] args) {
            new MyFutureAnonymousClass(){
                /** добавили новый метод нашему анонимному классу **/
                void my_new_method(){
                    System.out.println("Привет от анонима");
                }
            };
        }
    }
```

Но в таком виде наш пример не будет работать. Ведь у анонимного класса нет конструктора (т.к. нет имени),
кроме как конструктора базового класса. Как же нам быть? Как запустить наш метод, если у нас нет имени
класса, нет конструктора класса, а есть только метод?

У нас есть возможность выполнить наш метод из блока инициализации. Дописываем блок инициализации и выполняем наш метод:

```java
    public class MyFutureAnonymousClass {
    
        public static void main(String[] args) {
            new MyFutureAnonymousClass(){
                {
                            this.my_new_method();
                }
                /** добавили новый метод нашему анонимному классу **/
                void my_new_method(){
                    System.out.println("Привет от анонима");
                }
            };
        }
    }
```

Анонимными классами не следует злоупотреблять, иначе у вас получится код, в котором будет сложно разобраться и поддерживать. 
Анонимные (внутренние, вложенные, локальные) применяются для сокрытия реализации.

Анонимный вложенный класс не является членом содержащего его класса. Анонимный класс определяется и порождает экземпляр в 
момент использования. Он не определяется вместе с остальными членами включающего его класса. Анонимный класс можно поместить 
в любом месте программы, где разрешается применять локальные переменные.

В зависимости от контекста анонимный класс, член другого класса, ведет себя по-разному. В нестатическом контексте появляется 
окружающий его экземпляр, в статическом контексте ведет себя как статический.

**Цитата из книги 'Effective Java TM. Programming Language Guide.' - Joshua Bloch. :**
```
"Существуют четыре категории вложенных классов, каждая из которых занимает свое место:
- Если вложенный класс должен быть виден за пределами одного метода или он слишком длинный для того, чтобы его можно было удобно разместить в границах метода, используйте класс-член.
- Если каждому экземпляру класса-члена необходима ссылка на включающий его экземпляр, делайте его нестатическим, в остальных случаях он должен быть статическим.
Предположим, что класс находится внутри метода.
- Если вам нужно создавать экземпляры этого класса только в одном месте программы и уже есть тип, который характеризует это класс, сделайте его анонимным классом.
В противном случае, это должен быть локальный класс."
```

Анонимный класс может быть не только наследуемым от другого класса (как правило, абстрактного), но и имплементировать интерфейс. 
**Широкое применение анонимные классы находят в создании многопоточности на java, а также для создания «слушателей» события и «адаптеров».**

---
**Доп. материалы:**
- [Anonymous Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)
- [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

---
- [Java Anonymous Class](https://www.w3schools.com/java/java_anonymous.asp)
- [Anonymous Classes in Java **(from baeldung.com)**](https://www.baeldung.com/java-anonymous-classes)
- [Anonymous Inner Class in Java **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/anonymous-inner-class-java/)
- [What is an Anonymous Class in Java](https://codingnomads.com/java-anonymous-inner-class)
- [Anonymous Classes](https://algomaster.io/learn/java/anonymous-classes)
- [Java Anonymous Class Explained: No More Confusion](https://dev.to/satyam_gupta_0d1ff2152dcc/java-anonymous-class-explained-no-more-confusion-5987)
- [Java - Anonymous Classes](https://www.tutorialspoint.com/java/java_anonymous_class.htm)
- [Java Anonymous Class](https://hyperskill.org/university/java/java-anonymous-class)
- [How Anonymous Classes Work Internally in Java **(by Alexander Obregon)**](https://medium.com/@AlexanderObregon/how-anonymous-classes-work-internally-in-java-75c961b32237)
- [Where Java Anonymous Classes Live in Memory and How They Behave **(by Alexander Obregon)**](https://alexanderobregon.substack.com/p/where-java-anonymous-classes-live)
- [Anonymous Classes in Java](https://www.bytesize.press/anonymous-classes-in-java/)
- [Anonymous Classes in Java (with video)](https://codespindle.com/Java/Java_Anonymous_classes.html)
- [Anonymous Classes (PDF)](https://skeoop.github.io/java-intermed/Anonymous-Class.pdf)
