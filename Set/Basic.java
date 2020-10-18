import java.util.HashSet;
public class Test {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(true);
        hashSet.add("String");
        hashSet.add("String");
        System.out.println(hashSet); //[123, String, true]
    }
}
