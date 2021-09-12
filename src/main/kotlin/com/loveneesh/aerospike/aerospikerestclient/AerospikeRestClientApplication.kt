package com.loveneesh.aerospike.aerospikerestclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AerospikeRestClientApplication

fun main(args: Array<String>) {
	runApplication<AerospikeRestClientApplication>(*args)
}
