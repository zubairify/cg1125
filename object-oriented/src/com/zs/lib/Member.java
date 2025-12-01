package com.zs.lib;

public class Member {
	private String name;
	private Book bk;
	
	public Member(String name) {
		this.name = name;
	}
	
	public Book getBk() {
		return bk;
	}

	public void setBk(Book bk) {
		this.bk = bk;
	}

	public String getName() {
		return name;
	}

	public void status() {
		if(bk == null)
			System.out.println("No book is issued by " + name);
		else
			System.out.println(bk.getTitle() + " is issued by " + name);
	}
}
