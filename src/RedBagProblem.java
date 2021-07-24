import java.util.ArrayDeque;

public class RedBagProblem {
    public static void main(String[] args) {
        String s = "  （*（+2 3） （-100 （+ 20 10））） ";
        String[] arr = s.trim().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == "(-" || arr[i] == "(+" || arr[i] == "(*") {
                stack.push(arr[i]);
            } else if (arr[i].substring(0,1) == ")") {
                for(int j = 0; j < arr[i].length(); i++) {
                    calculator(stack);
                }
            } else if (arr[i] == ""){

            } else {
                stack.push(arr[i]);
            }
        }
        System.out.println(stack.peek());
    }
    public static void calculator (ArrayDeque<String> stack) {
        ArrayDeque<Integer> operand = new ArrayDeque<>();
        while(stack.peek() != "(-" || stack.peek() != "(+" || stack.peek() != "(*") {
            operand.push(Integer.valueOf(stack.pop()));
        }
        if(stack.peek() == "(-") {
            int res = operand.pop();
            while(!operand.isEmpty()) {
                res -= operand.pop();
            }
            stack.pop();
            stack.push(String.valueOf(res));
        } else if (stack.peek() == "(+") {
            int res = operand.pop();
            while(!operand.isEmpty()) {
                res += operand.pop();
            }
            stack.pop();
            stack.push(String.valueOf(res));
        } else if (stack.peek() == "(*") {
            int res = operand.pop();
            while(!operand.isEmpty()) {
                res *= operand.pop();
            }
            stack.pop();
            stack.push(String.valueOf(res));
        }
    }

}
