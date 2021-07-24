import java.util.*;

public class Try{
    static ArrayList<String> numset = new ArrayList<>();
    static ArrayList<String> wordset = new ArrayList<>();
    static int passwdLength;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        passwdLength = in.nextInt();
        int words = in.nextInt();
        while(words-- > 0) {
            String tmp = in.next();
            if(tmp.compareTo("a") >= 0) {
                wordset.add(tmp);
            } else {
                numset.add(tmp);
            }
        }
        Collections.sort(numset);
        Collections.sort(wordset);
        for(int i = 1; i <= passwdLength-2; i++) {
            backtraceNum(i, 0);
        }
    }

    public static void backtraceNum(int target, int start) {
        if(target == sb.length()) {
            backtraceWord(0);
            return;
        }
        for(int i = start; i < numset.size(); i++) {
            sb.append(numset.get(i));
            backtraceNum(target, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void backtraceWord(int start) {
        if(passwdLength == sb.length()) {
            System.out.println(sb.toString());
            return;
        }
        for(int i = start; i < wordset.size(); i++) {
            sb.append(wordset.get(i));
            backtraceWord(i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}