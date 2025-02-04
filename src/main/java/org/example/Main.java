package org.example;
import java.util.Vector;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
  public static Vector union (Vector a, Vector b) {
    Vector result = new Vector();
    for (int i = 0; i < a.size(); i++) {
      Object elem = a.elementAt(i);
      if (!result.contains(elem)) {
        result.add(elem);
      }
    }

    for (int i = 0; i < b.size(); i++) {
      Object elem = b.elementAt(i);
      if (!result.contains(elem)) {
        result.add(elem);
      }
    }

    return result;
  }

}