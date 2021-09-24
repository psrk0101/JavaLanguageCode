package graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *       1
 *     /   \
 *    /     \
 *   2       3
 *  / \     / \
 * 4   5   6   7
 * \    \ /   /
 *  \ -  8 - /
 *
 * Expect Result
 * 1번 Node에서 시작했을 때 : 1 2 4 8 5 6 3 7
 * */
public class DFSBasic {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input Number of Nodes");
        int nodeCount = Integer.parseInt(br.readLine());

        System.out.println("Input Number of Relationship");
        int numberOfRelationship = Integer.parseInt(br.readLine());

        DfsGraph dfsGraph = new DfsGraph(nodeCount);

        for(int i = 0; i < numberOfRelationship; i++){
            System.out.printf("Input RelationShip(%d/%d)\n", i+1, numberOfRelationship);
            String[] relationShip = br.readLine().split(" ");
            dfsGraph.put(Integer.parseInt(relationShip[0]), Integer.parseInt(relationShip[1]));
        }

        dfsGraph.printGraph();
        dfsGraph.dfs(1);
    }
}

class DfsGraph{
    private int nodeCount;
    private int[][] graph;
    private boolean[] visited;


    DfsGraph(int nodeCount){
        this.nodeCount = nodeCount;
        this.graph = new int[nodeCount + 1][nodeCount + 1];
        this.visited = new boolean[nodeCount + 1];
    }

    // 양방향 relationship
    void put(int x, int y){
        graph[x][y] = graph[y][x] = 1;
    }

    void printGraph(){
        for(int i = 1; i <= nodeCount; i++){
            for(int j = 1; j <= nodeCount; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    void dfs(int visitNode){
        this.visited[visitNode] = true;
        System.out.print(visitNode + " ");

        for(int i = 1; i <= nodeCount; i++){
            if(graph[i][visitNode] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }
}
