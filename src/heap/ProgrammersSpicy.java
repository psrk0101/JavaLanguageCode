package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/** 문제 설명
 *  - 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
 *  - 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만든다
 *  ==> 석은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 *
 *  - Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 *  - Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return하도록 solution 함수를 작성
 *
 *  만약 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
 * */

public class ProgrammersSpicy {
    public static void main(String[] args){
        int[] scoville = {1, 12, 3, 9, 10, 2};
        int K = 7;
        // expected return : 2
        System.out.println(new ProgrammersSpicy().solution(scoville, K));
    }

    public int solution(int[] scoville, int K){
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville)
        {
            queue.add(i);
        }

        int mostMin, secondMostMin, newScovile;

        try {
            while(!queue.isEmpty()){
                mostMin = queue.poll();
                if(mostMin >= K){
                    break;
                }
                secondMostMin = queue.poll();
                newScovile = mostMin + secondMostMin * 2;
                queue.add(newScovile);
                answer++;
            }
        }catch (Exception e){
            answer = -1;
        }

        return answer;
    }
}
