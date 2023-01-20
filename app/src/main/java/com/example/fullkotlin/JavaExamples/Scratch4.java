package com.example.fullkotlin.JavaExamples;

import java.util.ArrayList;
import java.util.HashMap;

public class Scratch4 {
    public static void main(String[] args) {
//        int[] nums = {1,2,1};
//        int i= 0;
//
//        for (i = 0; i < nums.length; i++){
//            System.out.println("Nums:= "+nums[i]);
//            i--;
//        }

        HashMap<String, HashMap<String, HashMap<String, ArrayList<String>>>> Main = new HashMap<String, HashMap<String, HashMap<String, ArrayList<String >>>>();
        HashMap<String, HashMap<String,ArrayList<String>>> outerMap= new HashMap<String, HashMap<String, ArrayList<String>>>();
        HashMap<String, ArrayList<String>> maininnerMap = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> innerMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> inner = new ArrayList<String>();
        ArrayList<String> inner1 = new ArrayList<String>();
        inner.add("InnerValue");
        inner.add("InnerValue1");
        inner.add("InnerValue2");
        inner1.add("R");
        inner1.add("A");
        inner1.add("H");
        maininnerMap.put("InnerKey", inner);
        outerMap.put("OuterKey", innerMap);
        Main.put("Main", outerMap);
//        String value = ((HashMap<String, ArrayList<String>>)outerMap.get("OuterKey")).get("InnerKey").get(1).toString();
        String value = ((HashMap<String,HashMap<String, ArrayList<String>>>)Main.get("Main")).get("OuterKey").get("InnerKey").get(1).toString();
        System.out.println("Retreived value is : " + value);
        System.out.println("Retreived entry set is : " + outerMap.entrySet());

    }

}
