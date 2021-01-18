package com.example.rmltest.model.users;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("pagination")
	private Pagination pagination;

	public Pagination getPagination(){
		return pagination;
	}
}