package stream.basic;

import java.util.stream.Stream;

public class Basic {
    public static void main(String[] args){
        String str = "a,  b,    c, d";
        // split "," & trim() space
        String[] strs = Stream.of(str.split(",")).map(String::trim).toArray(String[]::new);
    }
}
