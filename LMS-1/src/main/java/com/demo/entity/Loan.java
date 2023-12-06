package com.demo.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String book;
	
	private String member;
	
	private Date loanDate;
	
	private Date returnDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Loan(int id, String book, String member, Date loanDate, Date returnDate) {
		super();
		this.id = id;
		this.book = book;
		this.member = member;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
