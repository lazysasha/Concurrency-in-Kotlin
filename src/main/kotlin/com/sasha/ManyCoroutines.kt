package com.sasha

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

@DelicateCoroutinesApi
suspend fun createCoroutines(amount: Int) {
    val jobs = ArrayList<Job>()
    for(i in 1..amount) {
        jobs += GlobalScope.launch {
            delay(1000)
        }
    }

    jobs.forEach {
        it.join()
    }
}

fun main(args: Array<String>) = runBlocking {
    println("${java.lang.Thread.activeCount()} threads active at the start")
    val time = measureTimeMillis {
        createCoroutines(10_000)
    }
    println("${java.lang.Thread.activeCount()} threads active at the end")
    println("Took $time ms")
}