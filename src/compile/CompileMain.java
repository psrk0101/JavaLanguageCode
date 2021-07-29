package compile;

import compile.hasa.CompileA;

/** Command Compile
 * - Step1. src 보다 상위 Directory로 이동
 * - Step2. Input Command : javac -d <target directory> -cp src <MainClass>
 * */

public class CompileMain {
    private CompileA compileA;
    public static void main(String[] args){
        new CompileMain().run();
    }

    private void run(){
        compileA = new CompileA();
        compileA.a();
    }
}
