import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo{
    static boolean checkBalancedParentheses(String str){
        Stack <Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        char[] charArray = str.toCharArray();
        for (Character ch: charArray){
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)){
                if (stack.pop() != map.get(ch))
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String str = "{{{[Pawan]}";
        System.out.println(checkBalancedParentheses("[{Pawan}]")); //true
        System.out.println(checkBalancedParentheses("[{Pawan]")); //false
        System.out.println(checkBalancedParentheses("{{{[Pawan]")); //false
    }
}
