package com.example.massignment

import java.math.BigDecimal

fun main(){

    var num = readLine()?.toInt()
    println("Enter value:$num")

    for( i in 1..10) {


        //println(num)

        println(num.toString() + " x " + i + " = " +  (num!!* i))


    }
}