//Ref: https://www.youtube.com/watch?v=1uIwiIjw1fw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=14

import java.util.HashMap;
import java.util.Map;

public class Demo {
    static Map<String, Integer> createWordCountMap(String[] strArray){
        Map<String, Integer> map = new HashMap<>();
        for (String str: strArray){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        return map;
    }

    static boolean sufficiencyCheck(String str, int count, Map<String, Integer> map){
        if (!map.containsKey(str) || count > map.get(str)){
            return false;
        }
        return true;
    }

    static boolean checkPossibility(String[] magazine, String[] ransomNote){
        Map<String, Integer> mapMagazine = createWordCountMap(magazine);
        System.out.println("mapMagazine:" + mapMagazine);
        Map<String, Integer> mapRansomNote = createWordCountMap(ransomNote);
        System.out.println("mapRansomNote:" + mapRansomNote);
        for (String str: mapRansomNote.keySet()){
            boolean check = sufficiencyCheck(str, mapRansomNote.get(str), mapMagazine);
            if (check == false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] magazine = {"charity", "give", "me", "money"};
        String[] ransomNote1 = {"give", "me", "money"};
        String[] ransomNote2 = {"give", "me", "money","money"};
        System.out.println(checkPossibility(magazine, ransomNote1));//true
        System.out.println(checkPossibility(magazine, ransomNote2));//false
    }
}
