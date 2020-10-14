/*
    1 -- 3 -- 5
   /         /
  0         /
   \       /  
    2 -- 4 -- 6
 */
import java.util.*;

class Graph {
    List <List<Integer>> graph;
    boolean[] visited;
    public Graph(int nodes){
        graph = new ArrayList<>();
        for (int i=0; i< nodes; i++){
            graph.add(i, new ArrayList<>());
        }
        visited = new boolean[nodes];
    }
    public void addEdge (int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    public void DFS(int startIndex){
        Stack <Integer> stack = new Stack<>();
        stack.push(startIndex);
        visited[startIndex] = true;
        while (!stack.isEmpty()){
            int element = stack.pop();
            System.out.print(element + " ");
            for (int child: graph.get(element)){
                if (visited[child] != true){
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        int nodes = 7;
        Graph a = new Graph(7);
        a.addEdge(0,1);
        a.addEdge(0,2);
        a.addEdge(1,3);
        a.addEdge(2,4);
        a.addEdge(3,5);
        a.addEdge(4,5);
        a.addEdge(4,6);
        System.out.println("Adjacency List:" + a.graph.toString()); //Adjacency List:[[1, 2], [0, 3], [0, 4], [1, 5], [2, 5, 6], [3, 4], [4]]
        a.DFS(0); //0 2 4 6 5 3 1
    }
}
