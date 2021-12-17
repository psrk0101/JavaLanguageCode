package pattern.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildTest {
	public static void main(String[] args){
		BuilderObject obj = new BuilderObject().setMember1("A").setMember2("C");
				;

		BuilderObject obj2 = new BuilderObject();

		List<Integer> aa = new ArrayList<>();

		aa.add(2);
		aa.add(3);
		aa.add(10);
		aa.add(5);

		List<Integer> bbb = aa.stream()
				.filter(BuildTest::upperFour)
				.collect(Collectors.toList())
				;


		for(int i : aa){
			System.out.println(i);
		}

		for(int j : bbb){
			System.out.println(j);
		}
	}

	public static boolean upperFour(Integer i){
		return i > 4;
	}
}
