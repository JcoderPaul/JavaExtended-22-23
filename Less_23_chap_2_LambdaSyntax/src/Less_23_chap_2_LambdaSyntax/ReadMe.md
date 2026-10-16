- См. документацию (ENG): [The Java™ Tutorials - Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

---
### Лямбда выражения в Java

Среди новшеств, которые были привнесены в язык Java с выходом JDK 8, особняком стоят лямбда-выражения.
Лямбда представляет набор инструкций, которые можно выделить в отдельную переменную и затем многократно
вызвать в различных местах программы.

Основу лямбда-выражения составляет лямбда-оператор, который представляет собой стрелку `->`. Этот оператор 
разделяет лямбда-выражение на две части: 
- левая часть содержит список параметров выражения;
- правая представляет тело лямбда-выражения, где выполняются все действия.

Лямбда-выражение не выполняется само по себе, а образует реализацию метода, определенного в функциональном
интерфейсе. При этом важно, что функциональный интерфейс должен содержать только один единственный метод
без реализации.

В Java, лямбда-выражения имеют следующий синтаксис: `(parameter list) -> {lambda body}`

Тело лямбды может быть двух типов:

**1. Однострочные:**

```
  () -> System.out.println("Lambdas are great");
```

**2. Блочные (многострочные):**

```
  () -> {
    double pi = 3.1415;
    return pi;
  };
```

Многострочный тип позволяет лямбда-выражению иметь несколько операций внутри себя.
Эти операции должны быть помещены в фигурные скобки `{};`, после которых необходимо
ставить точку с запятой.

**Примечание: многострочные лямбда-выражения, всегда должны иметь оператор return, в отличие от однострочных.**

**3. Лямбда-выражения с параметрами:**

```
  (n) -> (n % 2) == 0
```

Как и методы, лямбды могут иметь параметры.

---
#### Отложенное выполнение

Одним из ключевых моментов в использовании лямбд является отложенное выполнение - deferred execution.
То есть мы определяем в одном месте программы лямбда-выражение и затем можем его вызывать при необходимости 
неопределенное количество раз в различных частях программы. 

**Отложенное выполнение может потребоваться, к примеру, в следующих случаях:**
- Выполнение кода в отдельном потоке;
- Выполнение одного и того же кода несколько раз;
- Выполнение кода в результате какого-то события;
- Выполнение кода только в том случае, когда он действительно необходим и если он необходим;

---
#### Передача параметров в лямбда-выражение

Параметры лямбда-выражения должны соответствовать по типу параметрам метода из функционального
интерфейса. При написании самого лямбда-выражения тип параметров писать необязательно, хотя в
принципе это можно сделать, например:

```
  operation = (int x, int y)->x+y;
```

Если метод не принимает никаких параметров, то пишутся пустые скобки, например:

```
  ()-> 30 + 20;
```

Если метод принимает только один параметр, то скобки можно опустить:

```
  n-> n * n;
```

---
#### Терминальные лямбда-выражения

Выше мы рассмотрели лямбда-выражения, которые возвращают определенное значение. Но также могут
быть и терминальные лямбды, которые не возвращают никакого значения.

---
#### Лямбды и локальные переменные

Лямбда-выражение может использовать переменные, которые объявлены во вне, в более общей области
видимости - на уровне класса или метода, в котором лямбда-выражение определено. Однако в зависимости
от того, как и где определены переменные, могут различаться способы их использования в лямбдах.

Пример использования переменных уровня КЛАССА:

```java
  public class MyLambdaApp {
  
      static int x = 10;
      static int y = 20;
  
      public static void main(String[] args) {
  
          Operation op = () -> {
              x = 30;
              return x + y;
          };
  
          System.out.println(op.calculate()); // 50
          System.out.println(x); // 30 - значение x изменилось
      }
  }
  
  interface Operation{
      int calculate();
  }
```

Переменные x и y объявлены на уровне класса, и в лямбда-выражении мы их можем получить и даже изменить.
Так, в данном случае после выполнения выражения изменяется значение переменной x. Однако на уровне метода,
картина немного другая (как и в локальных вложенных классах).

Пример использования локальных переменных на уровне метода:

```java
  public class MyLambdaApp {
      public static void main(String[] args) {
  
         int n = 70;
         int m = 30;

           Operation op = () -> {
               //n = 100; - так нельзя, поскольку не определена внутри выражения
               return m + n;
           };

         // n = 100;  - так тоже нельзя, переменная, используемая в лямбда-выражении, должна быть final или effectively final
         System.out.println(op.calculate()); // 100
      }
  }
  
  interface Operation{
      int calculate();
  }
```

Локальные переменные уровня метода мы также можем использовать в лямбдах, но изменять их значение нельзя.
Если мы попробуем это сделать, то среда разработки может нам высветить ошибку и то, что такую
переменную надо пометить с помощью ключевого слова final, то есть сделать константой: 

```
  final int n=70;
```

Однако это необязательно.

**Более того, мы не сможем изменить значение переменной, которая используется в лямбда-выражении, вне этого
выражения. То есть даже если такая переменная не объявлена как константа, по сути она является константой.**

---
#### Обобщенный функциональный интерфейс

Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не
допускается. В этом случае нам надо типизировать объект интерфейса определенным типом, который потом
будет применяться в лямбда-выражении.

Пример:

```java
  public class LambdaApp {
  
      public static void main(String[] args) {
  
          Operationable <Integer> operation1 = (x, y)-> x + y;
          Operationable <String> operation2 = (x, y) -> x + y;
  
          System.out.println(operation1.calculate(20, 10)); // 30
          System.out.println(operation2.calculate("20", "10")); // 2010
      }
  }

  interface Operationable<T>{
      T calculate(T x, T y);
  }
```

Таким образом, при объявлении лямбда-выражения ему уже известно, какой тип параметры будут представлять
и какой тип они будут возвращать.

---
**Доп. материал:**
- [The Java™ Tutorials - Lambda Expressions **(from ORACLE)**](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Java 8: Lambdas **(from ORACLE)**](https://www.oracle.com/technical-resources/articles/java/architect-lambdas-part1.html)
- [Java Lambda Expressions](https://www.w3schools.com/java/java_lambda.asp)
- [Java Lambda Expressions **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/lambda-expressions-java-8/)
- [Lambda Expressions and Functional Interfaces: Tips and Best Practices **(from baeldung.com)**](https://www.baeldung.com/java-8-lambda-expressions-tips)
- [Understanding Java Lambda Expressions and Method References](https://medium.com/@Zimmendra/understanding-java-lambda-expressions-and-method-references-f59ce7f0c2b0)
- [Java Lambda Expressions **(from jenkov.com)**](https://jenkov.com/tutorials/java/lambda-expressions.html)
- [How to Use Lambdas in Java](https://www.digitalocean.com/community/tutorials/how-to-use-lambdas-in-java)
- [Lambda Expressions in Java: Syntax, Rules and Examples](https://howtodoinjava.com/java/lambda-expressions/)
- [How to start working with Lambda Expressions in Java](https://www.freecodecamp.org/news/learn-these-4-things-and-working-with-lambda-expressions-b0ab36e0fffc/)
- [Lambda Expressions Java Tutorial](https://www.javacodegeeks.com/lambda-expressions-java-tutorial.html)
- [Java Lambda Expressions](https://www.programiz.com/java-programming/lambda-expression)
- [Practical Introduction to Java Lambda Expressions](https://yasasramanayaka.medium.com/practical-introduction-to-java-lambda-expressions-a8656a703091)

---
**[Lambda Expressions (from dev.java)](https://dev.java/learn/language/fp/lambdas/)**
- [1 - Writing Your First Lambda Expression](https://dev.java/learn/language/fp/lambdas/first-lambdas/)
- [2 - Using Lambdas Expressions in Your Application](https://dev.java/learn/language/fp/lambdas/functional-interfaces/)
- [3 - Writing Lambda Expressions as Method References](https://dev.java/learn/language/fp/lambdas/method-references/)
- [4 - Combining Lambda Expressions](https://dev.java/learn/language/fp/lambdas/combining-chaining-composing/)
- [5 - Writing and Combining Comparators](https://dev.java/learn/language/fp/lambdas/writing-comparators/)
