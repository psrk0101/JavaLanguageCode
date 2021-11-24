package programmers.two;

import java.util.HashSet;
import java.util.Set;

/** isPrime : 소수찾기
 *  Permutation : 순열
 * */
public class SearchSosu {
	public static void main(String[] args){
		/** Test case
		 * numbers  return
		 * "17"     3
		 * "011"    2
		 * */
		System.out.println(new SearchSosu().solution("17"));
	}

	public int solution(String numbers){
		String[] nums = numbers.split("");
		String[] output;
		int SIZE = nums.length;
		boolean[] isVisited = new boolean[SIZE];
		Set<Integer> primeNum = new HashSet<>();

		for(int i = 1; i <= SIZE; i++){
			output = new String[i];
			getPermutation(nums, output, isVisited, 0, SIZE, i,primeNum);
		}
		return primeNum.size();
	}

	private void getPermutation(String[] arr, String[] output, boolean[] isVisited, int depth, int SIZE, int r, Set<Integer> primeNum){
		if(depth == r){
			String result="";
			for(String s : output){
				result += s;
			}
			int number = Integer.parseInt(result);
			if(isPrimeNumber(number)) primeNum.add(number);
			return;
		}

		for(int i = 0; i < SIZE; i++){
			if(isVisited[i]) continue;
			isVisited[i] = true;
			output[depth] = arr[i];
			getPermutation(arr, output, isVisited, depth+1, SIZE, r, primeNum);
			isVisited[i] = false;
		}
	}

	private boolean isPrimeNumber(int num){
		if(num == 0 || num == 1) return false;
		for(int i = 2; i * i <= num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}
