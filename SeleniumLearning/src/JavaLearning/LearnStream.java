package JavaLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LearnStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<String>();
		names.add("java");
		names.add("php");
		names.add("ruby");
		names.add("python");
		names.add("percy");
		names.add("java");

		long count = names.stream().filter(s->s.startsWith("p")).count();
		
		System.out.println(count);
		
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		
		names.stream().sorted().forEach(s->System.out.println(s));
		
		System.out.println("************");
		names.stream().sorted().distinct().forEach(s->System.out.println(s));
		
		System.out.println("************");
		
		names.stream().sorted().map(s->s.toUpperCase()).forEach((s->System.out.println(s)));
		
		List newList= names.stream().sorted().distinct().collect(Collectors.toList());
		
		System.out.println("!!!!!!!!!!!!!!");
		
		System.out.println(newList.get(0));
	}

}
