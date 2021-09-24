package programmers.weekchallenge;

public class NotExistsNumberPlus {
    public static void main(String[] args){

    }

    public int solution(int[] numbers) {
        int answer = 0;
        for(int i = 1; i <= 9; i++){
            answer += i;
        }

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}
