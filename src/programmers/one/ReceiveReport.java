package programmers.one;

import java.util.*;

/** 신고결과 받기
 * - 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스텥 개발
 * 1) 각 유저는 한번에 한 명의 유저를 신고할 수 있음
 *  : 단, 신고 횟수에 제한은 없음
 *  : 서로 다른 유저를 계속해서 신고 가능
 *  : 한 유저를 여러번 신고할 수 있지만, 동일한 유저에 대한 신고횟수는 1회로 처리
 *
 * 2) k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
 *  : 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송
 *
 * */

public class ReceiveReport {
    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] result = new ReceiveReport().solution(id_list, report, k);
        for (int r : result){
            System.out.print(r + " ");
        }

    }

    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        // Step 1. Init data
        Map<String, Set<String>> user_reported = new HashMap<>();
        for(String s : id_list){
            user_reported.put(s, new HashSet<>());
        }

        // Step 2. Data Set
        for(String s : report){
            // r[0] = report user, r[1] = reported user
            String[] r = s.split(" ");
            user_reported.get(r[1]).add(r[0]);
        }

        Iterator<String> reported_keys = user_reported.keySet().iterator();
        while(reported_keys.hasNext()){
            String key = reported_keys.next();
            if(user_reported.get(key).size() >= k){
                Set<String> temp_reported_user = user_reported.get(key);
                Iterator<String> itor = temp_reported_user.iterator();
                while(itor.hasNext()){
                    String user = itor.next();
                    for(int i = 0; i < id_list.length; i++){
                        if(user.equals(id_list[i])){
                            answer[i]++;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
