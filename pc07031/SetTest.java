package com.ssafy.edu.f001;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		Set<String> s=new TreeSet<>();
		s.add("hello");
		s.add("allo");
		s.add("gello");
		s.add("Hello");
		s.add("hello");
		s.add("1");
		s.add("1");
		s.add("3");
	
		for (Iterator<String> iterator = s.iterator(); iterator.hasNext();) {
			String sss =  iterator.next();
			System.out.println(sss);
		}
		System.out.println("-----------------------------");
		Iterator<String> iterator2 = s.iterator();
		while(iterator2.hasNext()) {
			String st=iterator2.next();
			System.out.println(st);
		}
		
		
	}
}







