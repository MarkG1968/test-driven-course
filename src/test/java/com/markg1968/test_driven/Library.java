package com.markg1968.test_driven;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Title>titles =  new ArrayList<Title>();
	
	public List<Title> getListOfTitles() {
		return titles;
	}

	public void add(Title title) {
		titles.add(title);
		
	}

}
