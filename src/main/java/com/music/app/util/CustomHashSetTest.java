package com.music.app.util;

import java.util.*;
public class CustomHashSetTest extends AbstractSet {
   private HashMap<Object, Object> map = null;
   private static final Object tempObject = new Object();
   public CustomHashSetTest() {
      map = new HashMap<>();
   }
   public boolean add(Object object) {
      return map.put(object, tempObject)==null;
   }
   public static void main(String[] args) {
      CustomHashSetTest test = new CustomHashSetTest();
      test.add("India");
      test.add("Australia");
      test.add("England");
      test.add("Australia");
      test.add(null);
      for(Object object : test) {
         System.out.println(object.toString());
      }
   }
   @Override
   public Iterator iterator() {
      return map.keySet().iterator();
   }
   @Override
   public int size() {
      return map.size();
   }
}