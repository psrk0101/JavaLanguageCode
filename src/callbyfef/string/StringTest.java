package callbyfef.string;

public class StringTest {
    public static void main(String[] args){
        String a = "Hello";
        new StringTest().callByRef(a);
        System.out.println(a);

        String b = new StringTest().callByRef2(a);
        System.out.println(b);
    }

    private void callByRef(String a){
        a = "World";
    }

    private String callByRef2(String a){
        a = "World";
        return a;
    }
}
