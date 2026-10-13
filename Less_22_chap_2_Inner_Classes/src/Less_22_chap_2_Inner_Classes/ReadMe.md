### Inner Classes

Классы могут быть вложенными - nested, то есть могут быть определены внутри других классов.
Частным случаем вложенных классов являются внутренние классы - inner class.

Внутренний класс ведет себя как обычный класс за тем исключением, что его объекты могут быть
созданы только внутри внешнего класса.

Внутренний класс имеет доступ ко всем полям внешнего класса, в том числе закрытым с помощью
модификатора private. Аналогично внешний класс имеет доступ ко всем членам внутреннего класса,
в том числе к полям и методам с модификатором private.

Ссылку на объект внешнего класса из внутреннего класса можно получить с помощью выражения 
`Внешний_класс.внутренний_класс`, например:

```
  OuterClass outerObject = new OuterClass();
  OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```

Объекты внутренних классов могут быть созданы только в том классе, в котором внутренние классы
опеределены. В других внешних классах объекты внутреннего класса создать нельзя.

Еще одной особенностью внутренних классов является то, что их можно объявить внутри любого контекста,
в том числе внутри метода и даже в цикле.

**!!! Внутренние классы легко могут наследовать от других классов и имплементировать интерфейсы !!!**

**!!! Внутренние классы могут содержать свои внутренние классы, которые в свою очередь тоже могут
содержать вложения классов (хотя это усложняет чтение кода и рекомендуется избегать матрешек в любом виде)!!!**

---
**Доп. материал:**
- [The Java™ Tutorials - Inner Class Example **(by ORACLE)**](https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html)
- [Inner Class in Java](https://www.geeksforgeeks.org/java/inner-class-java/)
- [Java Inner Classes](https://www.w3schools.com/java/java_inner_classes.asp)
- [Inner Classes in Java](https://medium.com/@pratik.941/in-depth-tutorial-on-inner-classes-in-java-77f81207a3fc)
- [Inner Classes (Nested Classes) in Java](https://www.tpointtech.com/java-inner-class)
- [Inner Classes vs. Subclasses in Java](https://www.baeldung.com/java-inner-classes-vs-subclasses)
- [Java - Inner classes](https://www.tutorialspoint.com/java/java_innerclasses.htm)
- [4 Types of Java Inner Class – You Must Know!](https://data-flair.training/blogs/java-inner-class/)
- [Why can outer Java classes access inner class private members?](https://stackoverflow.com/questions/1801718/why-can-outer-java-classes-access-inner-class-private-members)
- [Java Inner Class](https://intellipaat.com/blog/java-inner-class/)
- [Вложенные внутренние классы или Inner Class в Java](https://javarush.com/groups/posts/2181-vlozhennihe-vnutrennie-klassih)
