class Father{
    private String a = "father";
    public Father(){
        say();
    }
    public void say(){
        System.out.println("i'm father"+a);
    }
}
class Sub extends Father{
    private String a = "child";
    @Override public void say(){
        System.out.println("i'm child"+a);
    }
}
public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Sub sub = new Sub();
    }
}
