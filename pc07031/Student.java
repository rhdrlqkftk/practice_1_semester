package com.ssafy.edu.f001;

public class Student implements Comparable<Student>{
	private String id;
	private String name;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Student s) {
		return this.id.compareTo(s.getId())  ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return this.id.equals(other.getId()) &&
				this.name.equals(other.getName());
	}
	
	
	
	
}
