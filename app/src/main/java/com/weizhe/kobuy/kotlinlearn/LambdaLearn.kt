package com.weizhe.kobuy.kotlinlearn

/**
 * {类描述}
 *
 * @author 01373102
 * @since 2021/1/10 5:03 PM
 */

fun main() {
    val method1: (String, String) -> Unit = {
        str1, str2 ->
        println("pamra1 is $str1, param2 is $str2")
    }

//    method1("aaa", "bbb")

    val method2 = { println("method without param or return") }

//    method2()

    val method3 : (String) -> Unit = {
        println("params1 is $it")
    }

//    method3("123")

    val method4: (Int) -> Unit = {
        when(it) {
            1 -> println("param is 1")
            in 20 .. 30 -> {
                println("param between 20 and 30")
            }
            else -> {
                println("unknown param")
            }
        }
    }

//    method4(1)
//    method4(30)
//    method4(31)

    var method5 : (Int, Int) -> Unit = {
        a, b ->
        var c = a+b
        print("$c")
    }

//    method5(1, 2)

    var method6 : (Int, Int) -> Unit = {
        a, _ ->
        print("param1 is $a")
    }

    method6(3, 5)
}