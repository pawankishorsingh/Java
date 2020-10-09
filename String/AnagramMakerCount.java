//https://www.youtube.com/watch?v=3MwRGPPB4tw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=12

import java.util.HashMap;
import java.util.Map;

public class Demo{
    static Map <Character, Integer> createCharacterCountHashMap(String str){
        Map <Character, Integer> map = new HashMap<>();
        for (char ch: str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }

    static int getExtrasInFirstMap(Map <Character, Integer> map1, Map <Character, Integer> map2){
        int result = 0;
        for (Character ch: map1.keySet()){
            if (!map2.containsKey(ch)){
                result += map1.get(ch);
            } else {
                result+= Math.abs(map1.get(ch)-map2.get(ch));
            }
        }
        return result;
    }

    static int charCountRemovalsToMakeAnagrams(String str1, String str2){
        Map <Character, Integer> map1 = createCharacterCountHashMap(str1);
        Map <Character, Integer> map2 = createCharacterCountHashMap(str2);
        int resultCount =0;
        resultCount += getExtrasInFirstMap(map1, map2);
        resultCount += getExtrasInFirstMap(map2, map1);
        return resultCount;
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "billion";
        System.out.println(charCountRemovalsToMakeAnagrams(str1, str2)); //6
    }
}
