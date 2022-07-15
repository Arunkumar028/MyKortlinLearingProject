package com.example.mykortlinlearingproject

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class TestingCorountiunes {
}
fun main(args : Array<String>)= runBlocking{
     for (i in 0..1000){
         // async(co)
//          GlobalScope.async() {
//               delay(1000)
//               println("arun")
//          }


          val job=async{
               delay(1)
               println(i)
          }
          job.await()
     }
}