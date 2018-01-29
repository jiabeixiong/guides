package com.guides.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList("yang","li","zhang");
		List<String> newNames = new ArrayList<String>() {
			{
				names.forEach(name->add(name));
			}
		};
		newNames.forEach(name->System.out.println(name));
	}

}
