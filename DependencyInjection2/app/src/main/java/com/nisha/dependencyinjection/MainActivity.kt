package com.nisha.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val classC = ClassC()
//        classC.startClassC() Without di
        val classC = ClassC()
        classC.classA = ClassA()
        classC.classB = ClassB()
        classC.startClassC()
    }
}