package test.codility;

import java.util.LinkedList;
import java.util.Queue;

public class CyclicRotation {
    public static void main(String[] args){
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 3;

        int[] value = new CyclicRotationSolution().solution(A, K);
        for(int i : value){
            System.out.print(i + " ");
        }
    }
}

class CyclicRotationSolution{
    public int[] solution(int[] A, int K) {
        K = K%A.length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = A.length-1; i >= 0; i--){
            queue.add(A[i]);
        }

        for(int i = 1; i <= K; i++){
            queue.add(queue.poll());
        }

        int value[] = new int[A.length];
        for(int i = A.length-1; i>=0; i--){
            value[i] = queue.poll();
        }

        return value;
    }
}
