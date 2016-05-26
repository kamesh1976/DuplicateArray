package com.nttdata.test;

import junit.framework.TestCase;

import org.junit.Test;

public class DeDupUnitTest extends TestCase {

	DeDup dedup;

	@Override
	protected void setUp() throws Exception {
		dedup = new DeDup();
		super.setUp();
	}

	@Test
	public void testRemoveDuplicate_Sucess() {
		Integer[] testInt = { 1, 2, 3, 2 };
		Integer[] result = dedup.removeDuplicates(testInt);
		assertNotNull(result);
		assertEquals(3, result.length);
	}

	@Test
	public void testRemoveDuplicate_NullException() {
		try {
			dedup.removeDuplicates(null);
			fail("Shoud throw null pointer exception");
		} catch (NullPointerException exp) {

		}
	}

	@Test
	public void testRemoveDuplicate_EmptyArrayNotFail() {
		Integer[] testInt = {};
		Integer[] result = dedup.removeDuplicates(testInt);
		assertSame(0, result.length);
	}

	@Test
	public void testRemoveDuplicate_SingleInput() {
		Integer[] testInt = { 1 };
		Integer[] result = dedup.removeDuplicates(testInt);
		assertSame(1, result.length);
	}

	@Test
	public void testRemoveDuplicate_MultipleSameInput() {
		Integer[] testInt = { -2, -2, -2 };
		Integer[] result = dedup.removeDuplicates(testInt);
		assertSame(1, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_Sucess() {
		Integer[] testInt = { 1, 2, 3, 2 };
		int[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(3, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_Exception() {
		try {
			dedup.removeDuplicatesByOriginalOrder(null);
			fail("Null Pointer exception");
		} catch (NullPointerException exp) {

		}
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_EmptyInput() {
		Integer[] testInt = {};
		int[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_SingleInput() {
		Integer[] testInt = { -1 };
		int[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_NegativeMultiple() {
		Integer[] testInt = { -1, -1 };
		int[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}
	
	// Test scenario for Remove Duplicate without using  collections API
	@Test
	public void testRemoveDuplicateWithoutCollection_Sucess() {
		Integer[] testInt = { 1, 2, 3, 2 };
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertEquals(3, result.length);
	}

	@Test
	public void testRemoveDuplicateWithoutCollection_Exception() {
		try {
			dedup.removeDuplicateWithoutCollection(null);
			fail("Null Pointer exception");
		} catch (NullPointerException exp) {

		}
	}

	@Test
	public void testRemoveDuplicateWithoutCollection_EmptyInput() {
		Integer[] testInt = {};
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	public void testRemoveDuplicateWithoutCollection_SingleInput() {
		Integer[] testInt = { -1 };
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	@Test
	public void testRemoveDuplicateWithoutCollection_NegativeMultiple() {
		Integer[] testInt = { -1, -1,-1 };
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}
}
