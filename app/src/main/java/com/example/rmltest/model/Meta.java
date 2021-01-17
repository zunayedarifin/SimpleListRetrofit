package com.example.rmltest.model;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("pagination")
	private Pagination pagination;

	public Pagination getPagination(){
		return pagination;
	}
}