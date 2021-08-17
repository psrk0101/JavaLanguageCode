package programmers.weekchallenge;

/** 상호 평가
 *
 * 대학 교수인 당신은, 상호평가를 통하여 학생들이 제출한 과제물에 학점을 부여하려고 합니다.
 * 아래는 0번부터 4번까지 번호가 매겨진 5명의 학생들이 자신과 다른 학생의 과제를 평가한 점수표입니다.
 * 점수표에서 i행 j열의 값은 i번 학생이 평가한 j번 학생의 과제 점수입니다.
 * 당신은 각 학생들이 받은 점수의 평균을 구하여, 기준에 따라 학점을 부여하려고 합니다.
 * 만약, 학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외하고 평균을 구합니다.
 *
 * 평균을 구한 뒤, 아래 기준에 따라 학점을 부여합니다.
 *    평균	            학점
 * 90점 이상	            A
 * 80점 이상 90점 미만	B
 * 70점 이상 80점 미만	C
 * 50점 이상 70점 미만	D
 * 50점 미만	            F
 * */
public class CoEvaluation {
    public static void main(String[] args){

    }

    private double calculateAvg(int[] score, int selfIndex){
        return 0;
    }

    private String calculateGrade(double score){
        return "A";
    }

    public String solution(int[][] scores){
        String answer = "";

        return answer;
    }
}
