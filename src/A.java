import java.util.HashMap;

public class A extends B{
    public static void main(String[] args) {
        B b = new B();
        B.say();
        A a = new A();
        A.say();
        C.say();
        System.out.println(C.i);
    }
}

class B{
    int i = 3;
    public static void say() {
        System.out.println("1234");
    }

interface C {
    int i = 3;
    static void say() {
        System.out.println("interface");
    }
}
}