package JavaLearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<String> names = new ArrayList<String>();
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("guru");
		names.add("pavi");
		names.add(0, "raj");
		names.set(0, "thra");
		//names.set(0, null)
		System.out.println(names);
		int s = names.size();
		
		System.out.println(s);
		
		for(int i=0;i<s;i++)
		{
			System.out.println(names.get(i));
		}
		
		for(String str : names)
		{
			System.out.println(str);
		}
		
		
		//Iterator<String> itr= names.iterator();
		System.out.println("*********************************");
		/****************Set****************/
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("selenium");
		set.add("python");
		set.size();
		
		System.out.println(set);
		System.out.println(set.size());
		
		for(String str : set)
		{
			System.out.println(str);
		}
		
		Iterator itr = set.iterator();
		
		/*for(int j=0;j<set.size();j++)
		{
		System.out.println("******************"+itr.next());
		}*/
		
		for(;itr.hasNext();)
		{
			System.out.println("++++++++++++++"+itr.next());
		}
/*****************************HashMap***************************/
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("Test", "Selenium");
		hm.put("Dev","Java");
		hm.put("Development","Python");
		hm.put("CI","Jenkin");
		System.out.println(hm);
		
		Set hsSet= hm.entrySet();
		
		Iterator iter = hsSet.iterator();
		
		while(iter.hasNext())
		{
			Map.Entry mp= (Map.Entry)iter.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
			
			
		}
		
		
		
	}

}
