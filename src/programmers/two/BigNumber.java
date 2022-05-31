package programmers.two;

public class BigNumber {
	public static void main(String[] args){
		/** Sample Case
		 *  number          k   return
		 *  "1924"          2   "94"
		 *  "1231234"       3   "3234"
		 *  "4177252841"	4   "775841"
		 *   321924,        2, 3924
		 * */

		System.out.println(new BigNumber().solution("321924", 2));
	}

	public String solution(String number, int k){
		String[] arr = number.split("");
		boolean[] isVisited = new boolean[arr.length];
		String[] output = {"0"};
		combination(arr, output, isVisited, 0, arr.length, arr.length-k);
		return output[0];
	}

	public void combination(String[] arr, String[] output, boolean[] isVisited, int start, int n, int r){
		if(r == 0){
			String value = "";
			for(int i = 0; i < n; i++){
				if(isVisited[i]){
					value += arr[i];
				}
			}
			if(Integer.parseInt(value) > Integer.parseInt(output[0])) output[0] = value;
			return;
		}

		for(int j = start; j < n; j++){
			if(isVisited[j]) continue;

			isVisited[j] = true;
			combination(arr, output, isVisited, start+1, n, r-1);
			isVisited[j] = false;
		}
	}
}
