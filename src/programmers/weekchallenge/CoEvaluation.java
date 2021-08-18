package programmers.weekchallenge;

import java.util.Arrays;

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
        int[][] test = {{50, 90}, {50, 87}};
        // int[][] test = {{70,49,90}, {68,50,38}, {73,31,100}};
        System.out.println(new CoEvaluation().solution(test));
    }

    public String solution(int[][] scores){
        int[] user_score;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < scores.length; i++){
            user_score = new int[scores[i].length];
            for(int j = 0; j < scores[i].length; j++){
                user_score[j] = scores[j][i];
            }
            sb.append(getGrade(getAvg(user_score, i)));
        }
        return sb.toString();
    }

    private double getAvg(int[] scores, int selfIndex){
        int sum = Arrays.stream(scores).sum();
        if(checkMinMax(scores, scores[selfIndex]) && checkUnique(scores, scores[selfIndex])){
            return (sum - scores[selfIndex]) / (scores.length - 1);
        }

        return sum / scores.length;
    }

    private boolean checkMinMax(int[] scores, int selfScore){
        Arrays.sort(scores);
        if(scores[0] == selfScore || scores[scores.length-1] == selfScore){
            return true;
        }
        return false;
    }

    private boolean checkUnique(int[] scores, int selfScore){
        int cnt=0;
        for(int score : scores)
        {
            if(score == selfScore){
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }

    private String getGrade(double avg_score){
        if(avg_score >= 90){
            return "A";
        }else if(avg_score >= 80 && avg_score < 90){
            return "B";
        }else if(avg_score >= 70 && avg_score < 80){
            return "C";
        }else if(avg_score >= 50 && avg_score < 70){
            return "D";
        }else{
            return "F";
        }
    }
}
