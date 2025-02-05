package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

public class JUnitTest {

  @Test
  public void testEmptyVectors() {
    Vector<Object> a = new Vector<>();
    Vector<Object> b = new Vector<>();
    Vector<Object> expected = new Vector<>();

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual, "Union of two empty vectors should be empty.");
  }

  @Test
  public void testOneEmptyVector() {
    Vector<Object> a = new Vector<>();
    Vector<Object> b = new Vector<>();
    b.add(1);

    Vector<Object> expected = new Vector<>();
    expected.add(1);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual, "Union of an empty vector and [1] should be [1].");


    Vector<Object> c = new Vector<>();
    Vector<Object> d = new Vector<>();
    c.add("string");

    Vector<Object> expected2 = new Vector<>();
    expected2.add("string");

    Vector<Object> actual2 = Main.union(c, d);
    assertEquals(expected2, actual2, "Union of an empty vector and [string] should be [string].");

  }

  @Test
  public void testSingleElementVectors() {
    // Both vectors have exactly one element, which happens to be the same.
    Vector<Object> a = new Vector<>();
    a.add(42);
    Vector<Object> b = new Vector<>();
    b.add(42);

    Vector<Object> expected = new Vector<>();
    // Because they overlap, we only expect one instance
    expected.add(42);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual, "Union of [42] and [42] should be [42].");


    Vector<Object> vectorA = new Vector<>();
    vectorA.add(7);

    Vector<Object> vectorB = new Vector<>();
    vectorB.add(8);

    Vector<Object> expectedOutput = new Vector<>();
    expectedOutput.add(7);
    expectedOutput.add(8);

    Vector<Object> actualOutput = Main.union(vectorA, vectorB);
    assertEquals(expectedOutput, actualOutput, "Union of [7] and [8] should be [7, 8].");

  }

  @Test
  public void testNonOverlappingElements() {
    // Test with integers
    Vector<Object> a = new Vector<>();
    a.add(1);
    a.add(2);
    a.add(3);

    Vector<Object> b = new Vector<>();
    b.add(4);
    b.add(5);
    b.add(6);

    Vector<Object> expected = new Vector<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);
    expected.add(4);
    expected.add(5);
    expected.add(6);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union of [1, 2, 3] and [4, 5, 6] should be [1, 2, 3, 4, 5, 6].");

    // Test with strings
    Vector<Object> aStr = new Vector<>();
    aStr.add("apple");
    aStr.add("banana");
    aStr.add("cherry");

    Vector<Object> bStr = new Vector<>();
    bStr.add("date");
    bStr.add("elderberry");
    bStr.add("fig");

    Vector<Object> expectedStr = new Vector<>();
    expectedStr.add("apple");
    expectedStr.add("banana");
    expectedStr.add("cherry");
    expectedStr.add("date");
    expectedStr.add("elderberry");
    expectedStr.add("fig");

    Vector<Object> actualStr = Main.union(aStr, bStr);
    assertEquals(expectedStr, actualStr,
        "Union of [apple, banana, cherry] and [date, elderberry, fig] should be [apple, banana, cherry, date, elderberry, fig].");
  }


  @Test
  public void testOverlappingElements() {
    // Overlapping elements test with integers
    Vector<Object> intVectorA = new Vector<>();
    intVectorA.add(1);
    intVectorA.add(2);
    intVectorA.add(3);

    Vector<Object> intVectorB = new Vector<>();
    intVectorB.add(3);
    intVectorB.add(4);
    intVectorB.add(5);

    Vector<Object> expectedInt = new Vector<>();
    expectedInt.add(1);
    expectedInt.add(2);
    expectedInt.add(3);
    expectedInt.add(4);
    expectedInt.add(5);

    Vector<Object> actualInt = Main.union(intVectorA, intVectorB);
    assertEquals(expectedInt, actualInt,
        "Union of [1, 2, 3] and [3, 4, 5] should be [1, 2, 3, 4, 5].");

    // Overlapping elements test with strings
    Vector<Object> strVectorA = new Vector<>();
    strVectorA.add("cat");
    strVectorA.add("dog");
    strVectorA.add("mouse");

    Vector<Object> strVectorB = new Vector<>();
    strVectorB.add("mouse");
    strVectorB.add("elephant");
    strVectorB.add("lion");

    Vector<Object> expectedStr = new Vector<>();
    expectedStr.add("cat");
    expectedStr.add("dog");
    expectedStr.add("mouse");
    expectedStr.add("elephant");
    expectedStr.add("lion");

    Vector<Object> actualStr = Main.union(strVectorA, strVectorB);
    assertEquals(expectedStr, actualStr,
        "Union of [cat, dog, mouse] and [mouse, elephant, lion] should be [cat, dog, mouse, elephant, lion].");
  }


  @Test
  public void testDuplicatesWithinVector() {
    // Test with integers having duplicates within each vector
    Vector<Object> intVectorA = new Vector<>();
    intVectorA.add(1);
    intVectorA.add(1);
    intVectorA.add(2);

    Vector<Object> intVectorB = new Vector<>();
    intVectorB.add(2);
    intVectorB.add(3);
    intVectorB.add(3);

    Vector<Object> expectedInt = new Vector<>();
    expectedInt.add(1);
    expectedInt.add(2);
    expectedInt.add(3);

    Vector<Object> actualInt = Main.union(intVectorA, intVectorB);
    assertEquals(expectedInt, actualInt,
        "Union of [1, 1, 2] and [2, 3, 3] should be [1, 2, 3].");

    // Test with strings having duplicates within each vector
    Vector<Object> strVectorA = new Vector<>();
    strVectorA.add("alpha");
    strVectorA.add("alpha");
    strVectorA.add("beta");

    Vector<Object> strVectorB = new Vector<>();
    strVectorB.add("beta");
    strVectorB.add("gamma");
    strVectorB.add("gamma");

    Vector<Object> expectedStr = new Vector<>();
    expectedStr.add("alpha");
    expectedStr.add("beta");
    expectedStr.add("gamma");

    Vector<Object> actualStr = Main.union(strVectorA, strVectorB);
    assertEquals(expectedStr, actualStr,
        "Union of [alpha, alpha, beta] and [beta, gamma, gamma] should be [alpha, beta, gamma].");
  }


  @Test
  public void testMultipleDuplicatesAcrossVectors() {
    // Tests more complex overlap/duplicate scenarios
    Vector<Object> a = new Vector<>();
    a.add(1);
    a.add(2);
    a.add(2);
    a.add(3);

    Vector<Object> b = new Vector<>();
    b.add(2);
    b.add(3);
    b.add(3);
    b.add(4);

    Vector<Object> expected = new Vector<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);
    expected.add(4);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union should remove duplicates across both vectors.");


    Vector<Object> aStr = new Vector<>();
    aStr.add("red");
    aStr.add("blue");
    aStr.add("blue");
    aStr.add("green");

    Vector<Object> bStr = new Vector<>();
    bStr.add("blue");
    bStr.add("green");
    bStr.add("green");
    bStr.add("yellow");

    Vector<Object> expectedStr = new Vector<>();
    expectedStr.add("red");
    expectedStr.add("blue");
    expectedStr.add("green");
    expectedStr.add("yellow");

    Vector<Object> actualStr = Main.union(aStr, bStr);
    assertEquals(expectedStr, actualStr,
        "Union should remove duplicates across both vectors for strings.");
  }

  @Test
  public void testNullElements() {
    Vector<Object> a = new Vector<>();
    a.add(null);
    a.add("a");

    Vector<Object> b = new Vector<>();
    b.add("b");
    b.add(null);

    Vector<Object> expected = new Vector<>();
    expected.add(null);
    expected.add("a");
    expected.add("b");

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union should correctly handle null elements, ensuring only one null is present.");
  }

  @Test
  public void testOriginalVectorsUnmodified() {
    // Ensures that union() doesn’t alter the original input vectors
    // (which can be ambiguous in some specifications).
    Vector<Object> a = new Vector<>();
    a.add(1);
    a.add(2);
    Vector<Object> b = new Vector<>();
    b.add(2);
    b.add(3);

    Vector<Object> aCopy = new Vector<>(a);
    Vector<Object> bCopy = new Vector<>(b);

    Main.union(a, b);

    assertEquals(aCopy, a, "union() should not modify the original 'a' vector");
    assertEquals(bCopy, b, "union() should not modify the original 'b' vector");
  }

  @Test
  public void testMixedTypeVectorsCombined() {
    // Example 1: Mixed types with nulls.
    {
      Vector<Object> a = new Vector<>();
      a.add(null);
      a.add(2);         // Integer
      a.add("three");   // String

      Vector<Object> b = new Vector<>();
      b.add(2);         // Duplicate Integer
      b.add(null);      // Duplicate null
      b.add(4.0);       // Double
      b.add("four");    // String

      Vector<Object> expected = new Vector<>();
      expected.add(null);
      expected.add(2);
      expected.add("three");
      expected.add(4.0);
      expected.add("four");

      Vector<Object> actual = Main.union(a, b);
      assertEquals(expected, actual,
          "Union should correctly handle mixed types with nulls without duplicating null values.");
    }

    // Example 2: Mixed types with different orderings.
    {
      Vector<Object> a = new Vector<>();
      a.add("apple");   // String
      a.add(10);        // Integer
      a.add(3.5);       // Double
      a.add(false);     // Boolean

      Vector<Object> b = new Vector<>();
      b.add(false);     // Duplicate Boolean
      b.add("banana");  // String
      b.add(10);        // Duplicate Integer
      b.add(7);         // Integer

      // Expected union:
      // - All elements from a in order,
      // - then additional elements from b that are not already present.
      Vector<Object> expected = new Vector<>();
      expected.add("apple");
      expected.add(10);
      expected.add(3.5);
      expected.add(false);
      expected.add("banana");
      expected.add(7);

      Vector<Object> actual = Main.union(a, b);
      assertEquals(expected, actual,
          "Union should combine mixed types and preserve the order of first occurrences.");
    }

    // Example 3: Mixed types with numeric values and similar-looking strings.
    {
      Vector<Object> a = new Vector<>();
      a.add(1);         // Integer
      a.add("hello");   // String
      a.add(1.0);       // Double (1 and 1.0 are distinct)

      Vector<Object> b = new Vector<>();
      b.add(1.0);       // Duplicate Double (from a)
      b.add("world");   // New String
      b.add("hello");   // Duplicate String

      // Expected union:
      // - 1 (Integer) is added first,
      // - "hello" from a,
      // - 1.0 (Double) next,
      // - then "world" from b.
      Vector<Object> expected = new Vector<>();
      expected.add(1);
      expected.add("hello");
      expected.add(1.0);
      expected.add("world");

      Vector<Object> actual = Main.union(a, b);
      assertEquals(expected, actual,
          "Union should treat numeric types separately (e.g., Integer 1 and Double 1.0) and avoid duplicating equivalent entries.");
    }
  }



  @Test
  public void testNullInputA() {
    Vector<Object> a = null;
    Vector<Object> b = new Vector<>();
    b.add(1);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      Main.union(a, b);
    });
    assertEquals("Input Vectors cannot be null.", exception.getMessage());
  }

  @Test
  public void testNullInputB() {
    Vector<Object> a = new Vector<>();
    a.add(1);
    Vector<Object> b = null;

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      Main.union(a, b);
    });
    assertEquals("Input Vectors cannot be null.", exception.getMessage());
  }

}
