package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** Parameter
 * - N : Number of Node
 * - M : Number of relations
 *
 *
 * ex>
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   \
 *  \ /     \
 *   6   -   7
 *
 * Expect Result
 * 1 - 2 - 3 - 4 - 5 - 7 - 6
 * */
public class BFSBasic {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int M;

        try {
            System.out.println("Input Number of Nodes");
            N = Integer.parseInt(br.readLine());
            System.out.println("Input Number of Relationships");
            M = Integer.parseInt(br.readLine());

            int[][] relationMap = new int[N+1][N+1];
            boolean[] visited = new boolean[N+1];

            // input relation
            int start;
            int end;
            String[] inputs;
            for(int i = 0; i < M; i++){
                System.out.println("Input relationships(ex> 1 2)");
                inputs = br.readLine().split(" ");
                start = Integer.parseInt(inputs[0]);
                end = Integer.parseInt(inputs[1]);

                relationMap[start][end] = 1;
                relationMap[end][start] = 1;
            }

            bfs(1, relationMap, visited);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int startPoint, int[][] relationsMap, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPoint);

        visited[startPoint] = true;

        while (!queue.isEmpty()){
            int point = queue.poll();
            System.out.println(point + " ");
            for(int i = 1; i < relationsMap.length; i++){
                if(relationsMap[i][point] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
