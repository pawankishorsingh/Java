import java.util.Stack;

public class Demo{
    static String reverseStringAtWordsUsingStack(String str){
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String delimiter = "\\s+";
        String[] parts = str.split(delimiter);
        for (String part:parts){
            if (part.length()>0){
                stack.push(part);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "Pawan Kishor Singh";
        System.out.println(reverseStringAtWordsUsingStack(str)); //Singh Kishor Pawan 
    }
}
