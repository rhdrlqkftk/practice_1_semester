package com.ssafy.edu.f001;

import java.util.Comparator;

public class TVCompPrice implements Comparator<TV> {

	@Override
	public int compare(TV o1, TV o2) {
		if(o1.getPrice()>o2.getPrice()) {
			return -1; // desc 
		}else if(o1.getPrice()<o2.getPrice()) {
			return 1; // desc 
		}else {
			if(o1.getWide()>o2.getWide()) {
				return -1; // desc 
			}else if(o1.getWide()<o2.getWide()) {
				return 1; // desc 
			}else {
				return 0;
			}
		}
	}

}
