package com.zs.lib;

public class Book {
	private String title;
	private Member mbr;
	
	public Book(String title) {
		this.title = title;
	}
	
	public Member getMbr() {
		return mbr;
	}

	public void setMbr(Member mbr) {
		this.mbr = mbr;
	}

	public String getTitle() {
		return title;
	}

	public void status() {
		if(mbr == null)
			System.out.println(title + " is not issued to anyone");
		else
			System.out.println(title + " is issued to " + mbr.getName());
	}
}
