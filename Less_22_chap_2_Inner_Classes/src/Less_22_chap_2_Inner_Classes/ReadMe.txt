********************************** Inner Classes **********************************

Классы могут быть вложенными (nested), то есть могут быть определены внутри других классов.
Частным случаем вложенных классов являются внутренние классы (inner class).

Внутренний класс ведет себя как обычный класс за тем исключением, что его объекты могут быть
созданы только внутри внешнего класса.

Внутренний класс имеет доступ ко всем полям внешнего класса, в том числе закрытым с помощью
модификатора private. Аналогично внешний класс имеет доступ ко всем членам внутреннего класса,
в том числе к полям и методам с модификатором private.

Ссылку на объект внешнего класса из внутреннего класса можно получить с помощью выражения =>
=> Внешний_класс.this, например, Person.this.

Объекты внутренних классов могут быть созданы только в том классе, в котором внутренние классы
опеределены. В других внешних классах объекты внутреннего класса создать нельзя.

Еще одной особенностью внутренних классов является то, что их можно объявить внутри любого контекста,
в том числе внутри метода и даже в цикле.

!!! Внутренние классы легко могут наследовать от других классов и имплементировать интерфейсы !!!
!!! Внутренние классы могут содержать свои внутренние классы, которые в свою очередь тоже могут
содержать вложения классов (хотя это усложняет чтение кода и рекомендуется избегать матрешек в любом виде)!!!