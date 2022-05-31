package test.codility;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args){
        int[] A = {1, 3, 2};
        new DistinctSolution().solution(A);
    }
}

class DistinctSolution{
    public int solution(int[] A) {
        if(A.length == 0 || A.length == 1) return A.length;
        Arrays.sort(A);
        int distinctCnt = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i-1] != A[i]) distinctCnt++;
        }

        return distinctCnt;
    }
}
