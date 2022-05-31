package programmers.skillcheck;

import java.util.ArrayList;
import java.util.List;

public class News {
	private final int weight = 65536;

	public static void main(String[] args){
		/** Test Case
		 *      Str1    Str2        result
		 *      E=M*C^2 e=m*c^2     65536
		 * */
		// System.out.println(new News().solution("E=M*C^2", "e=m*c^2"));

		System.out.println(new News().solution("FRANCE", "french"));

	}

	public int solution(String str1, String str2){
		List<String> str1List = getCharList(str1);
		List<String> str2List = getCharList(str2);

		if(str1List.isEmpty() || str2List.isEmpty()) return weight;

		double commonCnt = 0;

		for(String str1Char : str1List){
			for(int i =0 ; i < str2List.size(); i++){
				if(str1Char.equals(str2List.get(i))){
					str2List.remove(i);
					commonCnt++;
					break;
				}
			}
		}

		for(String ss : str1List){
			System.out.println(ss);
		}

		System.out.println(commonCnt);

		return (int)(commonCnt * weight/ (str1List.size() + str2List.size())) ;
	}

	private boolean isValidCharSet(String str){
		return str.matches("^[a-zA-Z]{2}$");
	}

	private List<String> getCharList(String str1){
		List<String> strList = new ArrayList<>();
		String str = "";
		for(int i = 0; i < str1.length(); i++){
			str += str1.charAt(i);
			if(i!=0 && i%2!=0){
				if(isValidCharSet(str)) strList.add(str.toUpperCase());
				str = "";
			}
		}
		str = "";
		for(int i = 1; i < str1.length(); i++){
			str += str1.charAt(i);
			if(i!=0 && i%2!=0){
				if(isValidCharSet(str)) strList.add(str.toUpperCase());
				str = "";
			}
		}
		return strList;
	}
}
