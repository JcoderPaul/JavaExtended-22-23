package Less_23_chap_1_Lambda.MyOwnClasses;

// Создали интерфейс
public interface MyInterface {
    /*
    Интерфейс имеет единственный метод, который принимает в качестве аргумента строку и возвращает INT.
    Значит класс подписанный на этот интерфейс должен будет реализовать некий функционал этого метода,
    который (в идеале) сделает что-нибудь со строкой и вернет INT по итогам своей работы.
    */
    int returnSomethingWhole(String str);
}
