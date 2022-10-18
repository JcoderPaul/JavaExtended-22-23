package Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses;

public class MyFutureAnonymousClass {
    public static void main(String[] args) {
        new MyFutureAnonymousClass(){
            {
                this.my_new_method();
            }
            // добавили новый метод нашему анонимному классу
            void my_new_method(){
                System.out.println("Привет от анонима (или ананима?)");
            }
        };
    }
}
