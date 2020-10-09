//Ref: https://gist.github.com/harshitkgupta/09c5946267d31b8999e33a50ac2394bd
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map< Character, TrieNode> children;
    boolean isLeafNode;
    int count;

    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
        isLeafNode = false;
        count =0;
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }

    public void setChild(char ch) {
        children.put(ch, new TrieNode());
    }

    public boolean isLeafNode() {
        return isLeafNode;
    }

    public void setLeafNode(boolean leafNode) {
        this.isLeafNode = leafNode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Trie {
    TrieNode root = new TrieNode();
    public boolean insert(String str){
        TrieNode head = root;
        head.setCount(head.getCount()+1);
        for (char ch: str.toCharArray()){
            if (head.getChild(ch) == null){
                head.setChild(ch);
            }
            head = head.getChild(ch);
            head.setCount(head.getCount()+1);
        }
        if (head.isLeafNode()){
            return false;
        }
        head.setLeafNode(true);
        return true;
    }
    public boolean searchCompleteWord(String str){
        TrieNode head = root;
        for (char ch: str.toCharArray()){
            head = head.getChild(ch);
            if (head == null){
                return false;
            }
        }
        return head.isLeafNode();
    }
    public int searchPartialWord(String str){
        TrieNode head = root;
        for (char ch: str.toCharArray()){
            head = head.getChild(ch);
            if (head == null){
                return 0;
            }
        }
        return head.getCount();
    }
}

public class Demo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("CAR");
        trie.insert("CAT");
        System.out.println(trie.searchCompleteWord("CAR")); //true
        System.out.println(trie.searchCompleteWord("COOL")); //false
        System.out.println(trie.searchPartialWord("CA")); //2
    }
}
