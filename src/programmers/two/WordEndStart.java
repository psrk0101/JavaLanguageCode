package programmers.two;
import java.util.*;

/** 영어 끝말잇기
 * - 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 *
 * (Rule)
 *
 * */

public class WordEndStart {
    public static void main(String[] args){
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        new WordEndStart().solution(3, words);
    }

    public int[] solution(int n, String[] words) {
        Set<String> his = new HashSet<>();
        String before = words[0];
        his.add(before);
        String after;
        for(int i = 1; i < words.length; i++){
            after = words[i];
            if(before.charAt(before.length()-1) != after.charAt(0)){
                return new int[]{i/n+1, i%n+1};
            }

            int curSize = his.size();
            his.add(after);
            if(curSize == his.size()){
                return new int[]{i/n+1, i%n+1};
            }
            before = after;
        }
        return new int[]{0, 0};
    }
}
