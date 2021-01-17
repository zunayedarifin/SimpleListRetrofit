package com.example.rmltest.model;

import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("total")
	private int total;

	@SerializedName("pages")
	private int pages;

	@SerializedName("limit")
	private int limit;

	@SerializedName("page")
	private int page;

	public int getTotal(){
		return total;
	}

	public int getPages(){
		return pages;
	}

	public int getLimit(){
		return limit;
	}

	public int getPage(){
		return page;
	}
}