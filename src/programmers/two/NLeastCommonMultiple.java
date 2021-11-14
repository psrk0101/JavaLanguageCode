package programmers.two;

/** int[] arr 배열에 존재하는 모든 수의 최소 공배수를 구해라
 * - 유클리드 호제법 사용
 * */
public class NLeastCommonMultiple {
    public int solution(int[] arr){
        if(arr.length == 1) return arr[0];

        int answer = lcm(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    private int gcd(int a, int b){
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while (max % min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }

    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}
