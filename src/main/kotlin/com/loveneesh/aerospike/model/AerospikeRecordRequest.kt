package com.loveneesh.aerospike.model

data class AerospikeRecordRequest(
        val namespace: String,
        val setName: String,
        val key: String,
        val data: List<BinData>
)

data class BinData(val name: String, val value: String)