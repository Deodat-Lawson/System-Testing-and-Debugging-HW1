package org.example;

import java.util.Vector;

public class Main {
  // Returns the union of two vectors as a new vector.
  //
  // The union is defined as follows:
  // - All elements from the first vector (parameter 'a') are added in their original order.
  // - Then, each element from the second vector (parameter 'b') is added only if it is not already
  //   present in the union (as determined by the equals() method).
  // - This process removes duplicate elements that occur within a single vector or across both vectors.
  //   For example, if an element appears in both 'a' and 'b', only the occurrence from 'a' is preserved.
  // - The ordering in the resulting vector is determined by the order of first occurrence: all elements
  //   from 'a' (in order), then any additional elements from 'b' (in order).
  //
  // Examples:
  // - union([1, 2, 3], [4, 5, 6]) returns [1, 2, 3, 4, 5, 6].
  // - union([1, 2, 3], [3, 4, 5]) returns [1, 2, 3, 4, 5] (duplicate 3 is removed).
  // - union([null, "a"], ["b", null]) returns [null, "a", "b"] (only one null is included).
  // - union([], [1]) returns [1] and union([1], []) returns [1].
  // - union([1, "two"], [3.14, "two"]) returns [1, "two", 3.14] (handles mixed types).
  //
  // Note: The input vectors are not modified by this method.
  //
  // Preconditions:
  // - 'a' must not be null.
  // - 'b' must not be null.
  //
  // Throws:
  // - IllegalArgumentException if either 'a' or 'b' is null.
  public static Vector<Object> union(Vector<Object> a, Vector<Object> b) {
    // Validate inputs: neither vector may be null.
    if (a == null || b == null) {
      throw new IllegalArgumentException("Input Vectors cannot be null.");
    }

    Vector<Object> result = new Vector<>();

    // Add each element from the first vector 'a' to the result.
    // The order is preserved and duplicates are avoided.
    for (int i = 0; i < a.size(); i++) {
      Object elem = a.elementAt(i);
      if (!result.contains(elem)) {
        result.add(elem);
      }
    }

    // Add each element from the second vector 'b' that is not already present in result.
    // This ensures that if an element is in both vectors, only the first occurrence (from 'a')
    // is included.
    for (int i = 0; i < b.size(); i++) {
      Object elem = b.elementAt(i);
      if (!result.contains(elem)) {
        result.add(elem);
      }
    }

    return result;
  }
}
