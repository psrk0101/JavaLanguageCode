package groom.levelone;

import java.io.*;
import java.util.Arrays;

public class TestAvg {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		double sum =0;
		int upPosition = 2;
		for(int score : scores){
			sum += score;
		}

		double avg = (double)Math.round((sum / scores.length)*Math.pow(10, upPosition)) / Math.pow(10, upPosition);
		if(avg >= 90){
			System.out.print(avg+" A");
		}else if(avg >= 80){
			System.out.print(avg+" B");
		}else if(avg >= 70){
			System.out.print(avg+" C");
		}else if(avg >= 60){
			System.out.print(avg+" D");
		}else{
			System.out.print(avg+" F");
		}
	}
}
