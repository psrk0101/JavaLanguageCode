package groom.levelone;

import java.io.*;

public class PlusDivisors {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		boolean[] isDivisor = new boolean[N+1];

		for(int i = 1; i <= Math.sqrt(N); i++){
			if(N%i == 0){
				isDivisor[i] = true;
				isDivisor[N/i] = true;
			}
		}

		for(int i = 1; i < isDivisor.length; i++){
			if(isDivisor[i]) System.out.printf("%d ", i);
		}
	}
}
