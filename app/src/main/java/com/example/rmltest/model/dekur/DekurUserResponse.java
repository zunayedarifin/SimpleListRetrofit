package com.example.rmltest.model.dekur;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DekurUserResponse {

	@SerializedName("message")
	private ArrayList<MessageItem> message;

	public ArrayList<MessageItem> getMessage(){
		return message;
	}
}