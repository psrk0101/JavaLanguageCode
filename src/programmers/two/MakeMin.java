package programmers.two;

import java.util.Arrays;

/** 길이가 같은 배열 A,B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
 * 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다.
 * 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
 * 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
 * (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
 *
 * * Idea
 *  - 두 개의 배열을 각각 asc, desc 정렬 후, 같은 index끼리 곱했을때 최소값이 출력되지 않을까?
 * */
public class MakeMin {
    public static void main(String[] args){
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        new MakeMin().solution(A, B);
    }

    public int solution(int[] A, int[] B){
        int answer = 0;
        int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i =0; i < size; i++){
            answer += A[i] * B[size-1-i];
        }

        return answer;
    }
}
