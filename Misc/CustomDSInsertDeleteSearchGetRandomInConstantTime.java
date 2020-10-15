import java.util.*;

class MyDS{
    Map<String, Integer> map;
    List <String> list;
    public MyDS(){
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    void insert(String str){
        if (map.get(str) != null){
            return;
        }
        list.add(str);
        map.put(str,list.size()-1);
    }
    void delete(String str){
        Integer index = map.get(str);
        if (index == null){
            return;
        }
        Collections.swap(list, index,list.size()-1);
        list.remove(list.size()-1);
        map.remove(str);
        map.put(list.get(list.size()-1), index);
    }
    boolean search (String str){
        if (map.containsKey(str))
            return true;
        return false;
    }
    String getRandom(){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
public class Demo {
    public static void main(String[] args) {
        MyDS myDS = new MyDS();
        myDS.insert("Pawan");
        myDS.insert("Romil");
        System.out.println("Map after addition of Pawan & Romil" + myDS.map.toString()); //{Romil=1, Pawan=0}
        System.out.println("Searh on Romil:" + myDS.search("Romil")); //true
        System.out.println("Searh on Sridhar:" + myDS.search("Sridhar")); //false
        System.out.println("Random Item:" + myDS.getRandom()); //Random Item:Romil
        myDS.delete("Romil");
        myDS.delete("Sridhar");
        System.out.println("Map after deletion of Romil: "+myDS.map.toString()); //Map after deletion of Romil: {Pawan=1}
        myDS.insert("akjain");
        System.out.println("Map after addition of akjain: "+myDS.map.toString()); //Map after deletion of Romil: {Pawan=1}
    }
}
