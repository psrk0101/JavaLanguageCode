package test.codility;

public class BinaryGap {
    public static void main(String[] args){
        new BinaryGapSolution().solution(1041);
    }
}

class BinaryGapSolution{
    public int solution(int N){
        String binary = getIntToBinary(N);
        int maxZeroBinaryCnt = 0;
        int tmpLength = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                if(maxZeroBinaryCnt < tmpLength) maxZeroBinaryCnt = tmpLength;
                tmpLength = 0;
            }else{
                tmpLength++;
            }
        }

        return maxZeroBinaryCnt;
    }

    private String getIntToBinary(int N){
        if(N == 1) return "1";
        if(N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(N%2);
            N /= 2;
        }while(N/2 != 0);
        return reverseString(sb.toString());
    }

    private String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
