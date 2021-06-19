package bitwise;

class BitAlgorithm {

    /** 특정 Index의 Bit값이 0인지 1인지 확인하는 Method
     * @Param
     * (1) num : 확인하고자 하는 숫자
     * (2) index : 확인하고자 하는 Bit의 index
     * */
    boolean getBit(int num, int index){
        return (num & (1 << index)) != 0;
    }

    /** 특정 숫자(num)의 특정 Index를 1로 셋팅하는 함수
     * @Param
     * (1) num : 처리하고자 하는 숫자
     * (2) index : 1로 변경하고자 하는 index
     */
    int setBit(int num, int index){
        return num | (1 << index);
    }

    /** 특정숫자(num)의 특정 Index를 0으로 변경하는 함수
     * - 특정 Index만 0 나머지는 1로 만들어 준 뒤, & 연산 실행
     * */
    int clearBit(int num, int index){
        return num & ~(1 << index);
    }

    /** 특정 Index를 중심으로 왼쪽에 위치하는 bit를 모두 0으로 바꾸고, 나머지는 그대로 유지시키는 Method
     * */
    int clearLeftBit(int num, int index){
        return num & ((1 << index) - 1);
    }

    int clearRightBit(int num, int index){
        return num & (-1 << (index + 1));
    }

    int updateBit(int num, int index, boolean val){
        return (num & ~(1 << index) | (val?1:0 << index));
    }
}
