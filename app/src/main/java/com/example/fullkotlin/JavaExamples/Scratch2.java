package com.example.fullkotlin.JavaExamples;

import java.util.ArrayList;

public class Scratch2 {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        ArrayList<String> result1 = new ArrayList<>();
        ArrayList<ArrayList<String>> result2 = new ArrayList<>();
        ArrayList<String> result3 = new ArrayList<>();

        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();

        ArrayList<Double> facepointX = new ArrayList<>();
        ArrayList<Double> facepointY = new ArrayList<>();

        X.add(5);
        X.add(6);
        X.add(7);
        X.add(8);
        X.add(9);
        X.add(55);
        X.add(66);
        X.add(33);
        X.add(66);
        X.add(99);
        X.add(65);

        Y.add(100);
        Y.add(110);
        Y.add(120);
        Y.add(130);
        Y.add(140);
        Y.add(150);
        Y.add(160);
        Y.add(170);
        Y.add(180);
        Y.add(190);
        Y.add(200);

        result1.add("3");
        result1.add("5");
        result1.add("4");

        result3.add("0");
        result3.add("2");
        result3.add("1");

        System.out.println("Result" +result1);

        result2.add(result1);
        result2.add(result3);
        System.out.println("Result2" +result2);

        System.out.println("X:-" +X);
        System.out.println("Y:-" +Y);


//        System.out.println("get1 : = " +result2.get(1).get(2));

        for( int i = 0; i < result2.size(); i++ ){
            for( int j = 0; j < result2.get(i).size(); j++ ){
                int index = Integer.parseInt(result2.get(i).get(j));
//                int index1 = index - 1;
                System.out.println("Index: = " +(index));
                facepointX.add(Double.valueOf(X.get(index)));
                System.out.println("X:- " +facepointX);
                facepointY.add(Double.valueOf(Y.get(index)));
                System.out.println("Y:- " +facepointY);
            }
        }

    }
}
