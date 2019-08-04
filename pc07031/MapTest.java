package com.ssafy.edu.f001;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Student> ss=new HashMap<>();
		ss.put("001", new Student("001","김길동"));
		ss.put("001", new Student("001","김길동"));
		ss.put("002", new Student("002","장길동"));
		ss.put("003", new Student("003","홍길동"));
		ss.put("004", new Student("004","이길동"));
		ss.put("005", new Student("005","조길동"));
		
		//Iterator<String> ids=ss.keySet().iterator();
		for (Iterator<String> iterator = ss.keySet().iterator(); iterator.hasNext();) {
			String key= iterator.next();
			Student st=ss.get(key);
			System.out.println(st);
		}
		
		
	}

}
