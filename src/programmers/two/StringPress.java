package programmers.two;

/** 문자열 압축
 * - 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 짧은 문자열로 줄여서 표현하는 알고리즘
 *
 * - ex> aabbaccc => 2a2ba3c
 * */
public class StringPress {
    public static void main(String[] args){
        String s = "aabbaccc";
        System.out.println(new StringPress().solution(s));
    }

    public int solution(String s){
        StringBuilder sb;
        int answer = s.length();

        String subSentence;
        for(int i = 0; i < s.length()/2; i++){
            sb = new StringBuilder();


            answer = sb.length() < answer ? sb.length() : answer;
        }

        System.out.println(s.substring(2, 4));
        /** 1일 떄,
         * 0, 1
         * 1, 2
         * 2, 3
         *
         * 2일 때,
         * 0, 2
         * 2, 4
         *
         * */


        return answer;
    }
}
