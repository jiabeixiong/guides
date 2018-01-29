package com.guides.java8;

import java.util.Arrays;
import java.util.List;

public class Main3 {

	public static void main(String[] args) {
		/*List<String> names = Arrays.asList("yang","li","zhang");
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		names.forEach((name)->{
			System.out.println(name);
		});*/
		
		List<String> names = Arrays.asList("yang","li","zhang");
		names.sort((o1,o2)-> o1.compareTo(o2));
		
		names.forEach((name)->{
			System.out.println(name);
		});
		
	}

}
