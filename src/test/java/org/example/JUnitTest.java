package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

public class JUnitTest {
  @Test
  public void testEmptyVectors() {
    Vector<Object> a = new Vector<>();
    Vector<Object> b = new Vector<>();
    Vector<Object> expected = new Vector<>();

    Vector actual = Main.union(a, b);
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
    assertEquals(expected, actual, "Union of [1, 2, 3] and [4, 5, 6] should be [1, 2, 3, 4, 5, 6].");



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
    assertEquals(expected, actual, "Union of [1, 2, 3] and [3, 4, 5] should be [1, 2, 3, 4, 5].");
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
    assertEquals(expected, actual, "Union of [1, 1, 2] and [2, 3, 3] should be [1, 2, 3].");
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
    assertEquals(expected, actual, "Union should correctly handle null elements.");
  }
//
//  @Test
//  public void testNullInputA() {
//    Vector<Object> a = null;
//    Vector<Object> b = new Vector<>();
//    b.add(1);
//
//    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//      Main.union(a, b);
//    });
//    assertEquals("Input Vectors cannot be null.", exception.getMessage());
//  }
//
//  @Test
//  public void testNullInputB() {
//    Vector<Object> a = new Vector<>();
//    a.add(1);
//    Vector<Object> b = null;
//
//    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//      Main.union(a, b);
//    });
//    assertEquals("Input Vectors cannot be null.", exception.getMessage());
//  }
}


