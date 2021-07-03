package programmers.two;

import java.util.Arrays;

/** 최대값과 최소값
 * - 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * - str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)" 형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * - 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴
 * */
public class MaxAndMin {
    public static final String EMPTY_STR = " ";
    public static void main(String[] args){
        String s = "-1 1 -3 2 4";
        System.out.println(new MaxAndMin().solution(s));
    }

    public String solution(String s){
        String[] strs = s.split(EMPTY_STR);
        Arrays.sort(strs, (o1, o2) -> {
                            return Integer.parseInt(o2) - Integer.parseInt(o1);
                            });
        return strs[strs.length-1] + EMPTY_STR + strs[0];
    }
}
