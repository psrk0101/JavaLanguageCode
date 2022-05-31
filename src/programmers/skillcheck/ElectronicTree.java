package programmers.skillcheck;

import java.util.LinkedList;
import java.util.Queue;

public class ElectronicTree {
	public static void main(String[] args){

	}

	public int solution(int n, int[][] wires){
		int answer = Integer.MAX_VALUE;
		int[][] matrix = new int[n+1][n+1];
		for(int[] wire : wires){
			matrix[wire[0]][wire[1]] = 1;
			matrix[wire[1]][wire[0]] = 1;
		}

		for(int[] wire : wires){
			int n1 = bfs(matrix, wire[0], wire[1], n);
			int n2 = bfs(matrix, wire[1], wire[0], n);
			answer = Math.min(answer, Math.abs(n1 - n2));
		}

		return answer;
	}

	private int bfs(int[][] matrix, int start, int disConnect, int n){
		boolean[] visited = new boolean[n+1];
		matrix[start][disConnect] = 0;
		matrix[disConnect][start] = 0;

		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;

		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()){
			int curIndex = queue.poll();
			cnt++;

			for(int i = 0; i < matrix.length; i++){
				if(matrix[i][curIndex] == 1 && !visited[i] && i != disConnect){
					queue.add(i);
					visited[i] = true;
				}
			}
		}

		matrix[start][disConnect] = 1;
		matrix[disConnect][start] = 1;
		return cnt;
	}
}
