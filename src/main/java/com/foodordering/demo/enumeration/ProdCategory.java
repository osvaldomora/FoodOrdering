package com.foodordering.demo.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProdCategory {
	VEG("VEG","just to vegan people"), NONVEG("NONVEG","just to people whi eat meat");


	

	private ProdCategory(String key, String description) {
		this.key = key;
		this.description = description;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//Variable clave
	private String key;
	//Variable description
	private String description;
	
	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	
	 @JsonCreator
	    public static ProdCategory getDepartmentFromCode(String value) {
	 
	        for (ProdCategory dep : ProdCategory.values()) {
	 
	            if (dep.getKey().equals(value)) {
	 
	                return dep;
	            }
	        }
	 
	        return null;
	    }
	
}
