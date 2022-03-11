package com.foodordering.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class StoreResponseDTO extends ResponseDTO{
	
	public StoreResponseDTO(String message, int statusCode) {
		super(message, statusCode);
		// TODO Auto-generated constructor stub
	}
	private List<StoreDetails> storeList = new ArrayList<>();
	//private ResponseDTO responseDTO;
	
	public List<StoreDetails> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<StoreDetails> storeList) {
		this.storeList = storeList;
	}
	
	
	
}
