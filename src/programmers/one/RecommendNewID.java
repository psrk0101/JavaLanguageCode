package programmers.one;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 신규 아이디 추천
 * - 새로 가입하는 유저들이 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것
 * - 아이디 Rule
 *  1) 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 *  2) 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)문자만 사용 가능
 *  3) 마침표는 처음과 끝에 사용할 수 없으며 연속으로 사용할 수 없습니다.
 *
 * - 7단계의 순차적인 처리 과정을 통해 검사 후, 새로운 아이디 추천
 *  Step1) new_id의 모든 대문자를 대응되는 소문자로 치환환
 *  Step2) new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표를 제외한 모든 문자를 제거
 *  Step3) new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 *  Step4) new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 *  Step5) new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
* */
public class RecommendNewID {
    private String new_id;

    public static void main(String[] args){
        String new_id = "=.=";
        String answer = new RecommendNewID().solution(new_id);
        String answer2 = new RecommendNewID().solutionTwo(new_id);
        System.out.println(new_id);
        System.out.println(answer);
        System.out.println(answer2);
    }

    public String solution(String new_id){
        setNewID(new_id);
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
        stepFive();
        stepSix();
        stepSeven();
        return getNewID();
    }

    private String getNewID(){
        return new_id;
    }

    private void setNewID(String new_id){
        this.new_id = new_id;
    }

    private void stepOne(){
        new_id = new_id.toLowerCase();
    }

    private void stepTwo(){
        new_id = new_id.replaceAll("[^\\w | \\- | _ | .]", "");
    }

    private void stepThree(){
        String regExp = "[.]{2}";
        Pattern p = Pattern.compile(regExp);;
        Matcher m = p.matcher(new_id);
        while(m.find()){
            new_id = new_id.replaceAll(regExp, ".");
            m = p.matcher(new_id);
        }
    }

    private void stepFour(){
        new_id = new_id.replaceAll("^[.]|[.]$", "");
    }

    private void stepFive(){
        if(new_id.isEmpty()) new_id = "a";
    }

    private void stepSix(){
        if(new_id.length() >= 16){
            if(new_id.charAt(14) == '.'){
                new_id = new_id.substring(0, 14);
            }else{
                new_id = new_id.substring(0, 15);
            }
        }
    }

    private void stepSeven(){
        while(new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length() - 1);
        }
    }

    public String solutionTwo(String new_id){
        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();

        return s;
    }

    private class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
