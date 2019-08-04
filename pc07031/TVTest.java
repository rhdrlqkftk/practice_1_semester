package com.ssafy.edu.f001;

import java.util.List;

public class TVTest {

	public static void main(String[] args) {
		TVMgr tvmgr=TVMgr.getInstance();
		tvmgr.add(new TV("tv lg 111", 35, 2000000));
		tvmgr.add(new TV("tv lg 113", 55, 5000000));
		tvmgr.add(new TV("tv lg 112", 45, 3000000));
		tvmgr.add(new TV("tv lg 114", 35, 6000000));
		tvmgr.add(new TV("tv lg 115", 60, 5000000));
		tvmgr.add(new TV("tv lg 116", 45, 3000000));
		List<TV> tvs=tvmgr.search();
		print(tvs);
		tvmgr.sortByPrice();
	    tvs=tvmgr.search();
		print(tvs);
	}
	
	public static void print(List<TV> tvs) {
		System.out.println("----------------");
		for (TV t : tvs) {
			System.out.println(t);
		}
	}
	
	
	

}
