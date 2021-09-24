package programmers.one;

/** 숫자 문자열과 영단어
 * - 네오와 프로도가 숫자 놀이를 하고 있습니다.
 * - 네오가 프로도에게 숫자를 선넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 *
 * */
public class NumberString {
    enum NumberEnm{
        ZERO("0", "zero")
        ,ONE("1", "one")
        ,TWO("2", "two")
        ,THREE("3", "three")
        ,FOUR("4", "four")
        ,FIVE("5", "five")
        ,SIX("6", "six")
        ,SEVEN("7", "seven")
        ,EIGHT("8", "eight")
        ,NINE("9", "nine")
        ;
        private String number;
        private String string;

        NumberEnm(String number, String string) {
            this.number = number;
            this.string = string;
        }

        String getNumber(){
            return this.number;
        }

        String getString(){
            return this.string;
        }
    }

    public static void main(String[] args){

    }

    public int solution(String s){
        s = s.toLowerCase();
        for (NumberEnm value : NumberEnm.values()) {
            s = s.replaceAll(value.getString(), value.getNumber());
        }

        return Integer.parseInt(s);
    }
}
