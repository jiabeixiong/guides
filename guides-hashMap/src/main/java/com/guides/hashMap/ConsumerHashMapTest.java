package com.guides.hashMap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConsumerHashMapTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        ConsumerHashMap<String, String> map = new ConsumerHashMap<String, String>();

        for (int i = 0; i < 1000; i++) {
            map.put(i + "", "this is value " + i);
            map.put(i + "", "this is value " + i);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println(map.get(i + ""));
        }


        System.out.println(" Consumer time: " + (System.currentTimeMillis() - startTime));



    }


}
