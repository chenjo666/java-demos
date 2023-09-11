package com.cj.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ArrayListGrowDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        List list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.println(list.size() + ":" +   getLength(list));
            list.add(i);
        }
    }
    public  static int getLength(List list) throws NoSuchFieldException, IllegalAccessException {
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        elementDataField.setAccessible(true);
        Object[] elementData = (Object[]) elementDataField.get(list);
        int length = elementData.length;
        return length;
    }
}
