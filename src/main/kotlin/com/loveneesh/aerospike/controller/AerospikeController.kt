package com.loveneesh.aerospike.controller

import com.loveneesh.aerospike.model.AerospikeRecordRequest
import com.loveneesh.aerospike.service.AerospikeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/aql")
class AerospikeController(
        val aerospikeService: AerospikeService
) {
    @GetMapping("/query")
    fun query(@RequestHeader namespace: String, @RequestHeader setName: String): List<MutableMap<String, Any>> {
        return aerospikeService.query(namespace, setName)
    }

    @PostMapping("/put")
    fun put(@RequestBody aerospikeRecordRequest: AerospikeRecordRequest) {
        aerospikeService.putRecords(aerospikeRecordRequest)
    }
}