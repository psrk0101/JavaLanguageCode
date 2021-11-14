package algorithm;

/** 유클리드 호제법
 * : 두 수의 최대 공약수를 구할 떄 사용되는 알고리즘
 *
 * - 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지는 r이라고 할 때
 * - a와 b의 최대공약수는 b와 r의 최대 공약수와 같다.
 * - 이 성질에 따라 b를 r로 나눈 나머지 r`를 구하고 다시 r을 r`으로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대 공약수가 됨
 * */

public class EuclideanAlgorithm {
    private int recursiveGcd(int a, int b){
        if(b == 0) return a;
        return recursiveGcd(b, a%b);
    }

    private int loopGcd(int a, int b){
        int tmp;
        while (b > 0){
            tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }


}
