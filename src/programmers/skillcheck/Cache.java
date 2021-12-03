package programmers.skillcheck;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args){

	}

	public int solution(int cacheSize, String[] cities){
		int answer = 0;
		Queue<String> cache = new LinkedList<>();
		for(String city : cities){
			city = city.toUpperCase();
			if(cache.contains(city)){
				answer++;
				cache.remove(city);
				cache.add(city);
			}else{
				if(cache.size() == cacheSize){
					cache.poll();
				}

				if(cache.size() < cacheSize){
					cache.add(city);
				}
				answer += 5;
			}
		}

		return answer;
	}
}
