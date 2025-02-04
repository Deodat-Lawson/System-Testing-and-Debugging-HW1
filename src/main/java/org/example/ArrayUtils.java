package org.example;

public class ArrayUtils {

    /* INSTRUCTIONS: For the following four methods:
       (a) Explain what is wrong with the given code. Describe the fault precisely by proposing a modification to the code.
       (b) If possible, give a test case that does not execute the fault. If not, briefly explain why not.
       (c) If possible, give a test case that executes the fault, but does not result in an error state. If not, briefly explain why not.
       (d) If possible give a test case that results in an error state, but not a failure. Hint: Don't forget about the program counter. If not, briefly explain why not.
       (e) For the given test case, describe the first error state as well as failure (if any). Be sure to describe the complete state.
       (f) Implement your repair and verify that the given test now produces the expected output.
       (g) Implement test cases developed in steps (b) through (e) in JUnit as separate test cases.
    */

    /**
     * Find last index of element
     *
     * @param x array to search
     * @param y value to look for
     * @return last index of y in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    // test: x = [2, 3, 5]; y = 2; Expected = 0
    public static int findLast (int[] x, int y) {
        for (int i=x.length-1; i > 0; i--) {
            if (x[i] == y) {
                return i;
            }
        }
        return -1;
    }

    /**
     * (a) The function doesn't account for the first element of the array being y. Propose to change the loop from 1 > 0 to 1 >= 0.
     * (b) [5, 3, 1, 2] y = 1. The last index of element 1 is in index 2
     * (c) [5, 3, 1, 2] y = 5. The last index of element 5 is in index 0
     * (d) ["five", "four", "three", "two", "one"] The input isn't matching int[]
     * (e) In the given test case, the program doesn't check index 0, causing a fault
     * (f) for (int i=x.length-1; i >= 0; i--) {
     *
     */




    /* INSTRUCTIONS: For the following four methods:
       (a) Explain what is wrong with the given code. Describe the fault precisely by proposing a modification to the code.
       (b) If possible, give a test case that does not execute the fault. If not, briefly explain why not.
       (c) If possible, give a test case that executes the fault, but does not result in an error state. If not, briefly explain why not.
       (d) If possible give a test case that results in an error state, but not a failure. Hint: Don't forget about the program counter. If not, briefly explain why not.
       (e) For the given test case, describe the first error state as well as failure (if any). Be sure to describe the complete state.
       (f) Implement your repair and verify that the given test now produces the expected output.
       (g) Implement test cases developed in steps (b) through (e) in JUnit as separate test cases.
    */

    /**
     * Find last index of zero
     *
     * @param x array to search
     * @return last index of 0 in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    // test: x = [0, 1, 0]; Expected = 2
    public static int lastZero (int[] x)  {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * (a) The function doesn't account for the first element of the array being 0
     * (b) [1, 2, 0, 1]. The last index of element 0 is in index 2
     * (c) [1, 0, 0, 1, 2] The last index of element 0 is in index 2, but the function returns index 1.
     * (d) ["five", "four", "three", "two", "one"] The input isn't matching int[]
     * (e) In the given test case, the program immediately returns the index when a 0 is detected. It will then return the first
     * index that is 0 instead of the last, causing a fault.
     * (f) for (int i=x.length-1; i >= 0; i--) {
     * (g)
     */




    /**
     * Count positive elements
     * *
     * @param x array to search
     * @return count of positive elements in x
     * @throws NullPointerException if x is null
     */
    // test: x = [-4, 2, 0, 2]; Expected = 2
    public static int countPositive (int[] x) {
        int count = 0;
        for (int i=0; i < x.length; i++) {
            if (x[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * (a) The function increases the count even when the element is 0, not positive.
     * (b) [1, -2, 0, -1]. There is only one positive element but the array returns 2
     * (c) [1, -5, -6, 1, 2] There are 3 positive elements and the function returns 3
     * (d) ["five", "four", "three", "two", "one"] The input isn't matching int[]
     * (e) In the given test case, the program return 3 as count will increment on index 1, 2, and 3.
     * (f) if (x[i] > 0) {
     * (g)
     */


    /**
     * Count odd or positive elements
     *
     * @param x array to search
     * @return count of odd/positive values in x
     * @throws NullPointerException if x is null
     */
    // test: x = [-3, -2, 0, 1, 4]; Expected = 3
    public static int oddOrPos(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i]%2 == 1 || x[i] > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * (a) The function doesn't increase count when we have a negative odd number.
     * (b) [1, -2, 0, -1]. The function will return 1 even though the there are two odd numbers
     * (c) [1, 4, 3, 1, 2] The function will return 3 which is correct.
     * (d) [2.1, 3.2, 4.5, 5] The input isn't matching int[]
     * (e) In the given test case, the program return 2 as count will only increment on index 3, 4
     * (f) if (x[i]%2 == 1 || x[i] > 0) {
     * (g)
     */



    /**
     * Find the length of the longest subarray with a sum less than or equal to k
     *
     * @param nums the array of integers
     * @param k the target number which must not be exceeded
     * @return the length of the longest subarray within nums such that the sum of elements of the subarray is less than or equal to k
     * @throws NullPointerException if nums is null
     */
    // test: nums = [-2, 0, 4, 5, 6] and k = 4; Expected = 3 (i.e., length of [-2, 0, 4] which is 3)
    public static int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    /**
     * (a) The function doesn't account for a negative sum in which the subarray must not exceed
     * (b) [1, -2, 0, -1]. The function will return 1 even though the there are two odd numbers
     * (c) [1, 4, 3, 1, 2] The function will return 3 which is correct.
     * (d) [2.1, 3.2, 4.5, 5] The input isn't matching int[]
     * (e) In the given test case, the program return 2 as count will only increment on index 3, 4
     * (f) if (x[i]%2 == 1 || x[i] > 0) {
     * (g)
     */

}
