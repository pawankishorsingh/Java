public class Demo {
    static String trimTheString(String str){
        String result = "";
        int i = 0;
        int j = str.length()-1;
        while (i <str.length()-1 && str.charAt(i) == ' ' ){
            i++;
        }
        while (j>=0 && str.charAt(j) == ' '){
            j--;
        }
        while(i<=j){
            result += str.charAt(i);
            i++;
        }
        return result;
    }
    public static void main(String[] args){
        String name = "   Pawan Kishor Singh  ";
        System.out.println(trimTheString(name)); //Pawan Kishor Singh
    }
}
