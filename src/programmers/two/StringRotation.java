package programmers.two;

import java.util.Stack;

public class StringRotation {
	private final char[] OPENS = {'(', '[', '{'};
	private final char[] CLOSES = {')', ']', '}'};

	public static void main(String[] args){
		System.out.println(new StringRotation().solution("[](){}"));
	}

	public int solution(String s){
		int answer = 0;
		for(int i = 1; i <= s.length(); i++){
			s = rotationString(s);
			answer += isExact(s);
		}
		return answer;
	}

	private String rotationString(String s){
		return s.substring(1) + s.charAt(0);
	}

	private int isExact(String s){
		Stack<Character> stack = new Stack();
		boolean isPoped;
		for(int i = 0; i < s.length(); i++){
			isPoped = false;
			if(stack.isEmpty()){
				stack.add(s.charAt(i));
			}else{
				char sc = stack.peek();
				for(int j = 0; j < OPENS.length; j++){
					if(sc == OPENS[j] && s.charAt(i) == CLOSES[j]){
						stack.pop();
						isPoped = true;
						break;
					}
				}
				if(!isPoped) stack.add(s.charAt(i));
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
