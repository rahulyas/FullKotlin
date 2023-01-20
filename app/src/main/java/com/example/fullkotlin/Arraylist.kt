package com.example.fullkotlin

class Arraylist {
    fun main(args:Array<String>){

        val arrayList = ArrayList<String>()
        arrayList.add("Ajay")
        arrayList.add("Vijay")
        arrayList.add("Prakash")
        arrayList.add("Rohan")
        arrayList.add("Vijay")
        println(".......print ArrayList.......")
        for (i in arrayList) {
            println(i)
        }


    }
}