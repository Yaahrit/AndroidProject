package com.nisha.dependencyinjection

import android.util.Log

//package com.nisha.dependencyinjection
//
//import android.util.Log
// Without di
//class ClassC {
//    private val classA = ClassA()
//    private val classB = ClassB()
//
//    fun startClassC(){
//        classA.startClassA()
//        classB.startClassB()
//        Log.i("TAG","Class C is Started")
//    }
//}

class ClassC {
    lateinit var classA: ClassA
    lateinit var classB: ClassB
    fun startClassC(){
        classA.startClassA()
        classB.startClassB()
        Log.i("TAG","Class C is Started")
    }
}