package bitwise;

class BitShiftOperator {

    /** LeftMove
     * - Syntax : x << y
     * - Description
     *  : 정수 x의 비트를 y만큼 왼쪽으로 이동
     * - ex
     *   2 << 3 : 000010 -> 010000
     *   2 -> 16
     * */
    void leftShiftOperator(){
        int i = 2 << 3;
        System.out.println(" 2 << 3 result : " + i);
    }


    /** RightMove
     * - Syntax : x >> y
     * - Description
     *  : 정수 x의 비트를 y만큼 오른쪽으로 이동
     * - ex
     *  16 >> 3 : 010000 -> 000010
     *  16 -> 2
     * */
    void rightShiftOperator(){
        int i = 16 >> 3;
        System.out.println(" 16 >> 3 result : " + i);

        /** Question
         *  - 만약 더 많이 이동시킨다면..?
         *  ex> 16 >> 5
         */
        int j = 16 >> 5;
        int k = 16 >> 96;
        int l = 16 >> 6;
        int m = 16 >> 32;
        System.out.println("OverFlow Shift Case1 : " + j); // 0
        System.out.println("OverFlow Shift Case2 : " + k); // 16 Why?
        System.out.println("OverFlow Shift Case3 : " + l); // 0
        System.out.println("OverFlow Shift Case4 : " + m); // 16
        /** 설명
         * int 자료형은 4byte(32bit)
         * - 0000 0000 0000 0000 0000 0000 0001 0000 (10진수 : 16)
         * - 16 >> 6일 경우
         * - 0100 0000 0000 0000 0000 0000 0000 0000이 되며, 기존의 값보다 큰 값이됨
         * - 큰 값일경우 0으로 출력되지만, 만약 작거나 같은 값일 경우 마치 loop처럼 변환됨
         * - 즉, 16 >> 32는 원점으로 오는것과 같은 효과가 됨
         * */
    }

    /** 오직 Java에만 있는 연산자
     * - Syntax : x <<< y OR x >>> y
     * - Shift 연산자의 경우 이동하더라도 숫자의 부호(+, -)는 유지됨. 하지만, unsinged는 유지안됨
     * - ex> -2147483648  >>> 30  : 3
     * : 1000 0000 0000 0000 0000 0000 0000 0000  >>>> 0000 0000 0000 0000 0000 0000 0000 0010
     * */
    void unsignedShiftOperator(){
        int i = -2147483648 >>> 30;
        System.out.println("-2147483648 >>> 30 : " + i);
    }
}
