package programmers.two;

import java.util.ArrayList;
import java.util.List;

/** 순위 검색
 *
 * 개발언어 : cpp, java, python
 * 지원 직군 : backend, frontend
 * 지원 경력 : junior, senior
 * 선호하는 소울푸드 : chicken, pizza
 *
 *
 * */
public class RankSearch {
	public static void main(String[] args){
		/** Test case
		 * String[] info ={
		 *      "java backend junior pizza 150",
		 *      "python frontend senior chicken 210",
		 *      "python frontend senior chicken 150",
		 *      "cpp backend senior pizza 260",
		 *      "java backend junior chicken 80",
		 *      "python backend senior chicken 50"
		 *      }
		 * String[] query = {
		 *      "java and backend and junior and pizza 100",
		 *      "python and frontend and senior and chicken 200",
		 *      "cpp and - and senior and pizza 250",
		 *      "- and backend and senior and - 150",
		 *      "- and - and - and chicken 100",
		 *      "- and - and - and - 150"
		 *      }
		 * */
	}

	public int[] solution(String[] info, String[] query){
		int[] answer = new int[query.length];
		List<Employee> employees = new ArrayList<>();

		for(String emp : info){
			employees.add(new Employee(emp));
		}


		for(String q : query){
			String[] queries = q.split(" ");
			int queryIndex = 1;
			while (queryIndex <= 5){

			}
		}


		return answer;
	}

	class Employee{
		private String language;
		private String group;
		private String carrer;
		private String food;
		private int score;

		Employee(String arg){
			String[] args = arg.split(" ");

			this.language = args[0];
			this.group = args[1];
			this.carrer = args[2];
			this.food = args[3];
			this.score = Integer.parseInt(args[4]);
		}
	}
}
