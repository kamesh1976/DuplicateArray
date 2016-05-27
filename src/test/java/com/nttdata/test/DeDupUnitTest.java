package com.nttdata.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class DeDupUnitTest extends TestCase {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17,
			8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3,
			20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	DeDup dedup;

	Map<Integer,Integer> withoutDuplicateMap = new HashMap<Integer,Integer>();
	@Override
	protected void setUp() throws Exception {
		dedup = new DeDup();
		super.setUp();
		for(int i:randomIntegers){
			withoutDuplicateMap.put(i, i);
		}
	}

	private static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;

	}

	@Test
	public void testRemoveDuplicate_Sucess() {	
		Integer[] result = dedup.removeDuplicates(toObject(randomIntegers));		
		assertNotNull(result);
		assertEquals(withoutDuplicateMap.size(), result.length);
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
		Integer[] result = dedup.removeDuplicatesByOriginalOrder(toObject(randomIntegers));
		assertNotNull(result);
		assertEquals(withoutDuplicateMap.size(), result.length);
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
		Integer[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_SingleInput() {
		Integer[] testInt = { -1 };
		Integer[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	@Test
	public void testRemoveDuplicatesByOriginalOrder_NegativeMultiple() {
		Integer[] testInt = { -1, -1 };
		Integer[] result = dedup.removeDuplicatesByOriginalOrder(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}

	// Test scenario for Remove Duplicate without using collections API
	@Test
	public void testRemoveDuplicateWithoutCollection_Sucess() {
		int[] result = dedup.removeDuplicateWithoutCollection(toObject(randomIntegers));
		assertNotNull(result);
		assertSame(withoutDuplicateMap.size(), result.length);
	}
	@Test
	public void testRemoveDuplicateWithoutCollection_False() {
		Integer[] testInt = { 1, 2, 3, 2 };
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertNotSame(withoutDuplicateMap.size(), result.length);
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
		Integer[] testInt = { -1, -1, -1 };
		int[] result = dedup.removeDuplicateWithoutCollection(testInt);
		assertNotNull(result);
		assertEquals(1, result.length);
	}
}
