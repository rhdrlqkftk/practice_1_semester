package com.ssafy.edu.f001;

public class TV {
	private String id;
	private int wide;
	private int price;
	public TV() {
	}
	public TV(String id, int wide, int price) {
		super();
		this.id = id;
		this.wide = wide;
		this.price = price;
	}
	@Override
	public String toString() {
		return "TV [id=" + id + ", wide=" + wide + ", price=" + price + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
