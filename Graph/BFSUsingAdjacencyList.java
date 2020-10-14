/*
      1 -- 4 -- 5
    /    /    /
  0 --    2
   \
     3 

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Graph {
    List <List<Integer>> graph;
    boolean[] visited;
    public Graph(int nodes){
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        for (int i=0; i< nodes; i++){
            graph.add(i,new ArrayList<>());
        }
    }
    void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    void BFS(int startIndex){
        Queue <Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        visited[startIndex] = true;
        while (!queue.isEmpty()){
            int element = queue.poll();
            System.out.print(element+" ");
            for (int child: graph.get(element)){
                if (visited[child] != true) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        int nodes = 6;
        Graph a = new Graph(nodes);
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(0, 3);
        a.addEdge(1, 4);
        a.addEdge(2, 4);
        a.addEdge(2, 5);
        a.addEdge(4, 5);
        System.out.println("Adjacency List: " + a.graph.toString()); //Adjacency List: [[1, 2, 3], [0, 4], [0, 4, 5], [0], [1, 2, 5], [2, 4]]
        a.BFS(0); //0 1 2 3 4 5
    }
}
