package com.guides.java8;

public class Main {

	public static void main(String[] args) {
		
		
		FunctionalInf f = new FunctionalInf() {

			@Override
			public String doSamething(String param) {
				return "this is inner class ...";
			}
			
		};
		
		System.out.println(f.doSamething(""));
		
		
		FunctionalInf f2 = param->param;
		
		System.out.println(f2.doSamething("ll "));
		
	}

}
