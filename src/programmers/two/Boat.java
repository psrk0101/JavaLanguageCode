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
        boolean[] isGrouping = new boolean[people.length];
        for(int i = 0; i < people.length; i++){
            int weight = 0;
            if(!isGrouping[i]){
                isGrouping[i] = true;
                weight += people[i];
                for(int j = people.length-1; j >= i; j--){
                    if(!isGrouping[j] && people[j] + weight <= limit){
                        isGrouping[j] = true;
                        weight += people[j];
                    }

                    if(weight == limit){
                        break;
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
