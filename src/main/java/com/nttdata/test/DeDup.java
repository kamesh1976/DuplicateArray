package com.nttdata.test;

import java.util.*;

/**
 * This class is used to remove Duplicate from the given Integer array.
 * 
 * The class has different type of method with major three approach which can
 * used to remove duplicate keeping the same order or random order from the
 * provided Integer array object. It also provide the feature to select user
 * where he wants the removed duplicate to be kept in the added Integer array or
 * the result can be any order with the provided boolean flag.
 * 
 * @author Kameshwar
 *
 */
public class DeDup {

    /** examle of random input int array which is used as for testing purpose */
    public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17,
                    8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9,
                    12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

    /**
     * This method used to remove duplicate from the input {@link Integer} arr.
     * It uses the HashSet class approach. While converting HashSet it remove
     * the duplicate elements. It store the removed duplicate element in random
     * order.
     * 
     * @param arr
     *            object of {@link Integer}
     * @return {@link Integer} array object with removed duplicate elements.
     */
    public Integer[] removeDuplicates( Integer[] arr ) {
        Set<Integer> setInteger = Collections.synchronizedSet(new HashSet<Integer>(Arrays.asList(arr)));
        return fromSetsToIntegerArray(setInteger);
    }

    /**
     * This method used to remove duplicate from the input {@link Integer} arr.
     * It uses the LinkedHashSet class approach. While converting HashSet it
     * remove the duplicate elements. It store the removed duplicate element in
     * the order it is present in input {@link Integer} array order.
     * 
     * @param arr
     *            object of {@link Integer}
     * @return int array object with removed duplicate elements.
     */
    public Integer[] removeDuplicatesByOriginalOrder( Integer[] arr ) {
        Set<Integer> setInteger = Collections.synchronizedSet(new LinkedHashSet<Integer>(Arrays.asList(arr)));
        return fromSetsToIntegerArray(setInteger);
    }

    /**
     * This method accept two parameter . One is provided {@link Integer} arr
     * objects which has duplicate elements and boolean flag to provide options
     * to user if he wants the return array in the order it was in original
     * provided input {@link Integer} array.
     * 
     * @param arr
     *            object of {@link Integer}
     * @param isMaintainOrder
     *            boolean flag to provide options of maintaining order of
     *            original objects after removing duplicate elements.
     * @return {@link Integer} array object with removed duplicate elements.
     */
    public Integer[] removeDuplicated( Integer[] arr , boolean isMaintainOrder ) {
        if ( isMaintainOrder ) {
            return removeDuplicatesByOriginalOrder(arr);
        } else {
            return removeDuplicates(arr);
        }
    }

    /**
     * This method used to remove duplicate from the input {@link Integer} arr.
     * It uses the Arrays class to sort the {@link Integer} array before
     * removing the duplicate elements and then check a position with its next
     * position. If they are not same, add value in a new array, otherwise skip
     * this iteration.
     * 
     * After the completion of Iteration it always add the last remaining
     * elements to new int array and increment the count. Finally it returned
     * the element from 0 position to count position.
     * 
     * @param arr
     *            object of {@link Integer}
     * @return int array object with removed duplicate elements.
     */
    public synchronized int[] removeDuplicateWithoutCollection( Integer[] arrays ) {
        int[] newArrays = new int[arrays.length];
        if ( null == arrays || arrays.length == 0 )
            return newArrays;
        Arrays.sort(arrays);
        int count = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            if ( arrays[i] != arrays[i + 1] ) {
                newArrays[count] = arrays[i];
                count++;
            }
        }
        newArrays[count] = arrays[arrays.length - 1];
        count++;
        return Arrays.copyOf(newArrays, count);
    }

    /**
     * This method convert Collections of Set<Integer> to {@link Integer}} array
     * 
     * @param setsInteger
     *            Collections of {@link Set} {@link Integer}
     * @return result Array of {@link Integer} object
     */
    public Integer[] fromSetsToIntegerArray( Set<Integer> setsInteger ) {
        Integer[] result = new Integer[setsInteger.size()];
        int count = 0;
        for (Integer integer : setsInteger) {
            result[count++] = integer;
        }
        return result;
    }

    /**
     * Util method to convert from {@link Integer} to int[] objects.
     * 
     * @param intArray
     *            {@link Integer} array object
     * @return int[] objects
     */
    private static Integer[] toObject( int[] intArray ) {

        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = Integer.valueOf(intArray[i]);
        }
        return result;

    }

    public static void main( String[] args ) {
        DeDup deDup = new DeDup();

        int[] result = deDup.removeDuplicateWithoutCollection(toObject(deDup.randomIntegers));
        for (int i : result) {
            System.out.print(i + " ,");
        }

    }

}
