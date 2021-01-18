package com.example.rmltest.model.dekur;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MessageItem implements Serializable {

	@SerializedName("number")
	private String number;

	@SerializedName("birthDay")
	private String birthDay;

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	public String getNumber(){
		return number;
	}

	public String getBirthDay(){
		return birthDay;
	}

	public String getImage(){
		return image;
	}

	public String getName(){
		return name;
	}
}