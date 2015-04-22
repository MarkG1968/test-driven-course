package com.markg1968.test_driven;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.easymock.EasyMock.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.markg1968.test_driven.Calculator;
import com.markg1968.test_driven.NumberProvider;

public class CalculatorTest {

	@Test
	public void canAddTwoNumbers() {

		int numberOne = 3;
		int numberTwo = 4;

		Calculator sut = new Calculator();

		assertThat(sut.add(numberOne, numberTwo), is(equalTo(numberOne + numberTwo)));
	}

	@Test
	public void canAddTwoNumbersWithOneFromProviderUsingEasyMock() {

		int numberOne = 3;
		int numberTwo = 4;

		NumberProvider numberProvider = createMock(NumberProvider.class);
		expect(numberProvider.getNumber()).andStubReturn(numberTwo);

		replay(numberProvider);

		Calculator sut = new Calculator();

		assertThat(sut.add(numberOne, numberProvider), is(equalTo(numberOne + numberTwo)));
	}

	@Test
	public void canAddTwoNumbersWithOneFromProviderUsingMockito() {

		int numberOne = 3;
		int numberTwo = 4;

		NumberProvider numberProvider = mock(NumberProvider.class);
		when(numberProvider.getNumber()).thenReturn(numberTwo);

		Calculator sut = new Calculator();

		assertThat(sut.add(numberOne, numberProvider), is(equalTo(numberOne + numberTwo)));
	}
}
