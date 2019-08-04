package com.ssafy.edu.f001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ListTest3 {

	public static void main(String[] args) {
		List<Student> ss=new ArrayList<>();
		Student s1=new Student("002","장길동");
		Student t=new Student("003","홍길동");
		ss.add( new Student("001","김길동"));
		ss.add( new Student("001","김길동"));
		ss.add( s1);
		ss.add( new Student("003","홍길동"));
		ss.add( new Student("004","이길동"));
		ss.add( new Student("005","조길동"));
		
		if(ss.contains(s1)) {
			System.out.println("있다.");
		}
		if(ss.contains(t)) {
			System.out.println("있다.");
		}else {
			System.out.println("없다.");
		}
		
		
		for (Iterator<Student> iterator = ss.iterator(); iterator.hasNext();) {
			Student key= iterator.next();
			System.out.println(key);
		}
		
		
	}

}
