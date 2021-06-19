package bitwise;

public class BitRunner {
    public static void main(String[] args){
        BitRunner br = new BitRunner();
        br.bitOperatorTest();
        br.bitAlgorithmTest();
    }

    private void bitOperatorTest(){
        BitShiftOperator bmo = new BitShiftOperator();
        bmo.leftShiftOperator();
        bmo.rightShiftOperator();
        bmo.unsignedShiftOperator();
    }

    private void bitAlgorithmTest(){
        BitAlgorithm ba = new BitAlgorithm();

        int num = 5;
        int index = 2;
        boolean returnVal = ba.getBit(5, 2);
        System.out.printf("%d의 %d번째 Index의 bit는 %b입니다.%n", num, index, returnVal);

        int index2 = 3;
        int num2 = ba.setBit(num, index2);
        System.out.printf("%d의 %d번째 Index를 1로 변경한 결과는 %d입니다.%n", num, index2, num2);
        // 0 1 0 1(5) ==> 1 1 0 1(13)

        int num3 = 169; // 10101001
        int index3 = 3;
        System.out.println(ba.clearLeftBit(num3, index3)); // 예상되는 결과 : 1
        System.out.println(ba.updateBit(num3, index3, false)); // 예상되는 결과 10100001 ==>  128 + 32 + 1 ==> 161

    }
}
