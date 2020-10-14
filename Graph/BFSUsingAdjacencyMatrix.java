/*
      1 -- 4 -- 5
    /    /    /
  0 --    2
   \
     3
 */
import java.util.*;

class Graph {
    int[][] graph;
    boolean[] visited;
    public Graph( int nodes) {
        graph = new int[nodes][nodes];
        visited = new boolean[nodes];
    }
    public void addEdge (int a, int b){
        graph[a][b]=1;
        graph[b][a]=1;
    }
    public void DFS(int startIndex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        visited[startIndex] = true;
        while (!queue.isEmpty()){
            int element = queue.poll(); //0
            System.out.print(element + " ");
            int[] adjacencyMartixRow = graph[element];
            for (int i=0; i<adjacencyMartixRow.length; i++ ) {
                if (visited[i] != true){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        int nodes=7;
        Graph a = new Graph(nodes);
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(0, 3);
        a.addEdge(1, 4);
        a.addEdge(2, 4);
        a.addEdge(2, 5);
        a.addEdge(4, 5);
        //System.out.println(Arrays.deepToString(a.graph));
        a.DFS(0); //0 1 2 3 4 5 6 
    }
}
