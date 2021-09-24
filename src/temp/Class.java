package temp;

import java.util.Scanner;

public class Class {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lineNumber=1;
        while(sc.hasNext()){
            System.out.printf("%d " + sc.nextLine() + "\n", lineNumber);
            lineNumber++;
        }
    }
}
