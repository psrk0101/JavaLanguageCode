package programmers.two;

import java.util.Stack;

/** 큰 수 만들기
 * - 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * - param
 * 1) String number : 숫자의 문자열 형식
 * 2) int k : 제거할 숫자의 개수
 *
 * - Question
 * : number에서 k개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 만드세요
 *
 * - ex
 * number   k   return
 * "1924"   2   "94"
 * "1231234"    3   "3234"
 * "4177252841" 4   "775841"
 * */
public class MakeMaxNumber {
    public static void main(String[] args){
        System.out.println(new MakeMaxNumber().solution("4177252841", 4));
    }

    public String solution(String number, int k){
        StringBuilder sb = new StringBuilder();
        int index = -1;

        // number.length()-k회 반복
        for(int i = 0; i < number.length()-k; i++){
            char maxChar = '0';
            for(int j = index+1; j <= i+k; j++){
                if(maxChar < number.charAt(j)){
                    index = j;
                    maxChar = number.charAt(j);
                }
            }
            sb.append(maxChar);
        }

        return sb.toString();
    }

    public String bestSolution(String number, int k){
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
