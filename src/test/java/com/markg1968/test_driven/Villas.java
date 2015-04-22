package com.markg1968.test_driven;

import java.util.Arrays;

public class Villas {
	private String[] villas;

	public Villas() {
		villas = new String[0];
	}

	public Villas(String[] names) {
		villas = names;
	}

	public static Villas none() {
		return new Villas();
	}
	
	public static Villas named(String... names) {
		return new Villas(names);
	}

	public boolean isEmpty() {
		return villas.length == 0;
	}

	public Iterable<String> all() {
		return Arrays.asList(villas);
	}
	
}
