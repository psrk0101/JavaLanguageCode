package programmers.two;

public class SwingMatrix {
	public static void main(String[] args){
		new SwingMatrix().solution(3, 3, new int[2][3]);
	}

	private void setMatrix(int[][] matrix, int rows, int columns){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				matrix[i][j] = i*rows + j+1;
			}
		}
	}

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] matrix = new int[rows][columns];
		setMatrix(matrix, rows, columns);
		for(int i=0; i < queries.length; i++){
			int[] query = queries[i];
			answer[i] = rotate(matrix, query);
		}
		return answer;
	}

	private int rotate(int[][] matrix, int[] query){
		int sX = query[0] - 1;
		int sY = query[1] - 1;
		int eX = query[2] - 1;
		int eY = query[3] - 1;

		int min = matrix[sX][sY];
		int tmp = min;

		int[] dX = {1, 0, -1, 0};
		int[] dY = {0, 1, 0, -1};
		int idx = 0;

		int curX = sX;
		int curY = sY;
		while(idx < 4){
			int nextX = curX + dX[idx];
			int nextY = curY + dY[idx];

			if(nextX < sX || nextX > eX || nextY < sY || nextY > eY){
				idx++;
			}else{
				matrix[curX][curY] = matrix[nextX][nextY];
				min = Math.min(min, matrix[curX][curY]);
				curX = nextX;
				curY = nextY;
			}
		}

		min = Math.min(min, tmp);
		matrix[sX][sY + 1] = tmp;

		return min;
	}
}

class Solution {
	private static int[][] arr;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int min;

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		arr = new int[rows][columns];
		int value = 1;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = value++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			min = Integer.MAX_VALUE;
			answer[i] = rotate(query);
		}

		return answer;
	}

	private int rotate(int[] query) {
		int sX = query[0] - 1;
		int sY = query[1] - 1;
		int eX = query[2] - 1;
		int eY = query[3] - 1;

		int temp = arr[sX][sY];
		int idx = 0;

		int curX = sX;
		int curY = sY;

		while (idx < 4) {
			int nextX = curX + dx[idx];
			int nextY = curY + dy[idx];

			if (nextX < sX || nextY < sY || nextX > eX || nextY > eY) {
				idx++;
			} else {
				arr[curX][curY] = arr[nextX][nextY];
				min = Math.min(min, arr[curX][curY]);
				curX = nextX;
				curY = nextY;
			}
		}

		arr[curX][curY + 1] = temp;

		min = Math.min(min, arr[curX][curY + 1]);

		return min;
	}
}
