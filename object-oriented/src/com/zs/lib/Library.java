package com.zs.lib;

public class Library {

	public void issueBook(Book b, Member m) throws LibraryException {
		if(b.getMbr() == null && m.getBk() == null) {
			m.setBk(b);
			b.setMbr(m);
			System.out.println("Book issued");
		} else
			throw new LibraryException("Book cannot be issued");
	}
	
	public void returnBook(Book b, Member m) throws LibraryException {
		if(b.getMbr() != null && m.getBk() != null && b.getMbr().getName().equals(m.getName())
				&& m.getBk().getTitle().equals(b.getTitle())) {
			m.setBk(null);
			b.setMbr(null);
			System.out.println("Book returned");
		} else
			throw new LibraryException("Book cannot be returned");
	}
}
