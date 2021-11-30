package programmers.three;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/** 디스크 컨트롤러
 * - 하드디스크는 한 번에 하나의 작업만 수행 가능
 * */
public class DiscController {
	public static void main(String[] args){
		/** sample
		 *  jobs    return
		 *  {{1, 9},{0, 3},{2, 6}}
		 * */
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(new DiscController().solution(jobs));
	}

	// int[][] jobs = {작업이 요청되는 시점, 작업의 소요시간}
	public int solution(int[][] jobs){
		int answer = 0;
		int jobIndex = 0;
		int executeCnt = 0;
		int beforeEndTime = 0;
		Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
		Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

		while(executeCnt < jobs.length){
			while(jobIndex < jobs.length && jobs[jobIndex][0] <= beforeEndTime ){
				queue.add(jobs[jobIndex++]);
			}

			if(queue.isEmpty()){
				beforeEndTime = jobs[jobIndex][0];
			}else{
				int[] task = queue.poll();
				answer += (task[1] - task[0] + beforeEndTime); // Execution Time
				beforeEndTime += task[1];
				executeCnt++;
			}
		}
		return (int)Math.floor(answer / jobs.length);
	}

}
