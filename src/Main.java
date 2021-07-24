import java.util.*;

public class Main{

    public static void main(String args[]) {
        String str1 = "hello ";
        String str2 = "java";
        String str3 = str1 + str2;
        String str4 = new StringBuilder().append(str1).append(str2).append("!").toString();
        String str5 = "hello java";
        String str6 = "hello " + "java";
        System.out.println(str6 == str5);

    }
}