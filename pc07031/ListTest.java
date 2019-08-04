package com.ssafy.edu.f001;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> s=new ArrayList<>();
		s.clear();
		s.add("hello");
		s.add("allo");
		s.add("gello");
		s.add("Hello");
		s.add(1,"kello");
		s.set(0,"Gollo");
		s.add("hello");
		s.add("1");
		s.add("1");
		s.add("3");
		System.out.println(s.contains("hello"));
		System.out.println("-------");
		for (int i = 0; i < s.size(); i++) {
			String ss=s.get(i);
			System.out.println(ss);
		}
		for (String t:s) {
			System.out.println(t);
		}
		
		
		
		
		
	}

}
