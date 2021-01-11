package com.weizhe.kobuy.kotlinlearn

fun main() {
    doLogin("123", "qwe") {
        if (it) {
            println("login success")
        }else{
            println("login fail")
        }
    }
}

fun doLogin(userName:String, password:String, onResult: (Boolean) -> Unit) {
    if ("1234" == userName && "qwe" == password) {
        onResult(true)
    }else{
        onResult(false)
    }
}