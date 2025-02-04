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
    assertEquals(expected, actual,
        "Union of two empty vectors should be empty.");
  }

  @Test
  public void testOneEmptyVector() {
    Vector<Object> a = new Vector<>();
    Vector<Object> b = new Vector<>();
    b.add(1);

    Vector<Object> expected = new Vector<>();
    expected.add(1);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union of an empty vector and [1] should be [1].");
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
    assertEquals(expected, actual,
        "Union of [42] and [42] should be [42].");
  }

  @Test
  public void testNonOverlappingElements() {
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
  }

  @Test
  public void testOverlappingElements() {
    Vector<Object> a = new Vector<>();
    a.add(1);
    a.add(2);
    a.add(3);

    Vector<Object> b = new Vector<>();
    b.add(3);
    b.add(4);
    b.add(5);

    Vector<Object> expected = new Vector<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);
    expected.add(4);
    expected.add(5);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union of [1, 2, 3] and [3, 4, 5] should be [1, 2, 3, 4, 5].");
  }

  @Test
  public void testDuplicatesWithinVector() {
    Vector<Object> a = new Vector<>();
    a.add(1);
    a.add(1);
    a.add(2);

    Vector<Object> b = new Vector<>();
    b.add(2);
    b.add(3);
    b.add(3);

    Vector<Object> expected = new Vector<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);

    Vector<Object> actual = Main.union(a, b);
    assertEquals(expected, actual,
        "Union of [1, 1, 2] and [2, 3, 3] should be [1, 2, 3].");
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
