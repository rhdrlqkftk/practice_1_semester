package com.ssafy.edu.f001;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TVMgr {
	
	private ArrayList<TV> tvs=new ArrayList<>();
	private static TVMgr tvm=new TVMgr();
	private TVMgr() {
		tvs.clear();
	}
	public static TVMgr getInstance() {
		return tvm;
	}
	public List<TV> search(){
		return this.tvs;
	}
	public void sortByPrice() {
		this.tvs.sort(new TVCompPrice());
		//Collections.sort(this.tvs, new TVCompPrice());
	}
	// new interface(){구현}
	public void sortByPrice2() {
		tvs.sort(new Comparator<TV>() {
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
		});
		
	}
	public void sortByPrice3() {
		tvs.sort((TV o1, TV o2) -> {
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
			});
		
	}
	public void add(TV ttv) {
		TV stv= findById(ttv.getId()); 
		if(stv==null) {
			tvs.add(ttv);
		}
	}
	private TV findById(String id) {
		TV tv=null;
		for (TV a : tvs) {
			if(a.getId().equals(id)) {
				tv=a;
			}
		}
		return tv;
	}
	
	
	
}
