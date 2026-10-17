См. док. (ENG): 
- [`removeIf(Predicate<? super E> filter)`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#removeIf-java.util.function.Predicate-)
- [`Interface Predicate<T>`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
- [`Collection.removeif()`](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#removeIf-java.util.function.Predicate-)

---
### Метод removeIf() - удаление элемента по предикату (Java 8)

Раньше, если нужно было удалить элемент из списка по условию, приходилось проходить в цикле по всем элементам и сравнивать их 
с условием. В Java 8 появился новый метод `removeIf()`, позволяющий упростить код. Метод использует предикат - вы указываете 
условие, если оно выполняется, то происходит удаление элемента из списка.

```
  default boolean removeIf( Predicate <? super E > filter)
```
Метод интерфейса Collection? который удаляет все элементы этой коллекции, удовлетворяющие заданному предикату - условию. 
Ошибки или исключения времени выполнения, возникающие во время итерации или из-за предиката, передаются вызывающей стороне.

**Требования к реализации:** Реализация по умолчанию обходит все элементы коллекции, используя её итератор `iterator()`. 
Каждый соответствующий элемент удаляется с помощью итератора `Iterator.remove()`. Если итератор коллекции не поддерживает 
удаление, то будет выброшено исключение [UnsupportedOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html) 
для первого соответствующего элемента.

**Параметры:** filter- предикат, возвращающий значение `true` для элементов, подлежащих удалению.

**Возвращает:** true - если какие-либо элементы были удалены

**Исключения:**
- [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html) - если указанный фильтр равен нулю;
- [UnsupportedOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html) - если элементы из этой коллекции удалить невозможно.

Реализации могут генерировать это исключение, если соответствующий элемент удалить не удается или если удаление, как правило, не поддерживается.

**Пример:**

```java
  ArrayList<Integer> numList = new ArrayList<>();
  
  numList.add(51);
  numList.add(14);
  numList.add(11);
  numList.add(12);
  numList.add(31);
  numList.add(21);
  
  System.out.println("Оригинал: " + numList.toString()); // Оригинал: [51, 14, 11, 12, 31, 21]
  
  /**
  Используем метод removeIf к нашему ArrayList и удаляем элементы,
  которые больше 10 и меньше 20. В метод передается лямбда выражение.
  **/
  numList.removeIf(i -> (i > 10 && i < 20));
  
  System.out.println("Новый список: " + numList.toString()); // Новый список: [51, 31, 21]
```

---
**Доп. материалы:**
- [`removeIf(Predicate<? super E> filter)`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#removeIf-java.util.function.Predicate-)
- [`Interface Predicate<T>`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
- [`Collection.removeif()`](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#removeIf-java.util.function.Predicate-)

--- 
- [ArrayList removeIf() Method in Java with Examples **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/arraylist-removeif-method-in-java/)
- [Java Collection removeIf() Method **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/java-collection-removeif-method/)
- [Java ArrayList removeIf() Method **(from w3schools.com)**](https://www.w3schools.com/JAVA/ref_arraylist_removeif.asp)
- [Java - removeIf example **(from stackoverflow.com)**](https://stackoverflow.com/questions/43246613/java-removeif-example)
- [ArrayList removeIf() in Java: Remove Elements by Condition](https://howtodoinjava.com/java/collections/arraylist/arraylist-removeif/)
- [Removing Elements from Java Collections **(from baeldung.com)**](https://www.baeldung.com/java-collection-remove-elements)
- [Removing an Element From an ArrayList **(from baeldung.com)**](https://www.baeldung.com/java-arraylist-remove-element)
- [Java ArrayList removeIf() Method](https://www.tutorialspoint.com/java/util/arraylist_removeif.htm)
- [Java 8 - Collection.removeIf method tutorial with examples](https://www.javabrahman.com/java-8/java-8-collection-removeif-method-tutorial-with-examples/)
- [Java ArrayList.removeIf() Method](https://www.w3resource.com/java-tutorial/arraylist/arraylist_removeif.php)
