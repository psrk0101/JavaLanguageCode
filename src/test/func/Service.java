package test.func;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Service {
	public static void main(String[] args){

	}

	public static void main(Function<Map, List> aa, Map<String, Object> paramMap){
		aa.apply(paramMap);
	}
}
