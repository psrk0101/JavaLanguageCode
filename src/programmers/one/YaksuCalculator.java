package programmers.one;

/** 약수의 개수와 덧셈
 * - 두 정수 left와 right가 매개변수로 주어집니다.
 * - left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요
 * - idea : 만약 해당 숫자가 제곱근일 경우 약수의 개수는 홀수, 제곱근이 아닐경우 홀수
 * */
public class YaksuCalculator {
    public static void main(String[] args){
        System.out.println(new YaksuCalculator().solution(13, 17));
    }

    public int solution(int left, int right){
        int answer = 0;
        Double sqrtNum;
        for(int i = left; i <= right; i++){
            sqrtNum = Math.sqrt(i);
            answer = (sqrtNum == sqrtNum.intValue()) ? answer - i : answer + i;
        }
        return answer;
    }
}
