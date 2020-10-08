import java.util.*;

public class Demo {
    static boolean anagramCheckUsingForLoops(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        boolean[] visited = new boolean[str2.length()];
        for (int i=0; i<str1.length(); i++){
            for (int j=0; j<str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j) && visited[j]==false){
                    visited[j]=true;
                    break;
                }
            }
        }
        for (boolean b: visited){
            if (b == false)
                return false;
        }
        return true;
    }
    static boolean anagramCheckUsingSorting(String str1, String str2){
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        int len1 = charArray1.length;
        int len2 = charArray2.length;
        if (len1 != len2){
            return false;
        }
        for (int i=0; i<len1; i++){
            if (charArray1[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }
    static boolean anagramCheckUsingHashMap(String str1, String str2){
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: str1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for (char ch: str2.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)-1);
            if (map.get(ch) ==0)
                map.remove(ch);
        }
        if (map.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String str1 = "listet";
        String str2 = "silent";
        System.out.println("Are anagrams? " + anagramCheckUsingForLoops(str1, str2)); //Are anagrams? true
        System.out.println("Are anagrams? " + anagramCheckUsingSorting(str1, str2)); //Are anagrams? true
        System.out.println("Are anagrams? " + anagramCheckUsingHashMap(str1, str2)); //Are anagrams? true
    }
}
