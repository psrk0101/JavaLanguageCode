package programmers.two;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args){
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(new Boat().solution(people, limit));
    }

    public int solution(int[] people, int limit){
        int answer = 0;
        Arrays.sort(people);
        int forward = 0;
        int backward = people.length - 1;
        int weight;
        while(forward < backward){
            weight = people[forward] + people[backward];
            if(weight > limit){
                backward--;
            }else{
                backward--;
                forward++;
            }
            answer++;
        }

        if(forward == backward) answer++;

        return answer;
    }
}
