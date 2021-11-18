package groom.levelone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitBasic2 {
	public static void main(String[] args) throws Exception {

		// 0101 >> 1 ==> 011 ==> 0001 ==> 0000
		System.out.println(5 >> 3);
		// 0101 << 1 1010 -> 10100 -> 101000 ==> 2^5(32) + 2^3(8) ==> 40
		System.out.println(5 << 3);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(arr[0] >> arr[1]);
		System.out.println(arr[0] << arr[1]);

		boolean[] a = new boolean[2];

	}
}
