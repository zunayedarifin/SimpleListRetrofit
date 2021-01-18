package com.example.rmltest.model.users;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	@SerializedName("meta")
	private Meta meta;

	public int getCode(){
		return code;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}

	public Meta getMeta(){
		return meta;
	}
}