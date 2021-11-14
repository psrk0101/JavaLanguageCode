package programmers.two;

public class NumberPresent {
    public static void main(String[] args){

    }

    public int solution(int n){
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                if(sum > n){
                    break;
                }else if(sum == n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    /** 정수론 정리
     *  - 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수개의 합과 같다.
     * */
    public int solution2(int n){
        int answer = 0;
        for(int i = 1; i <= n; i += 2){
            if(n % i == 0){
                answer++;
            }
        }
        return answer;
    }
}
