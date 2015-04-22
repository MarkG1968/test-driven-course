package com.markg1968.test_driven;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class LibraryTest {

	@Test
	public void itKnowsAboutTitles() {
		Library library = new Library();
		
		assertEquals(0, library.getListOfTitles().size());
	}

	@Test
	public void whenANewTitleIsAddedThenTheLibraryKnowsAboutIt() {
		
		Title title = mock(Title.class);
		Library library = new Library();
		
		library.add(title);
		
		assertEquals(1, library.getListOfTitles().size());
	}

}
