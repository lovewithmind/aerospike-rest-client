package com.loveneesh.aerospike.service

import com.aerospike.client.AerospikeClient
import com.aerospike.client.Bin
import com.aerospike.client.Key
import com.aerospike.client.policy.QueryPolicy
import com.aerospike.client.policy.WritePolicy
import com.aerospike.client.query.Statement
import com.loveneesh.aerospike.model.AerospikeRecordRequest
import org.springframework.stereotype.Service

@Service
class AerospikeService(
        val aerospikeClient: AerospikeClient
) {
    fun query(namespace: String, setName: String): List<MutableMap<String, Any>> {
        println("Querying records from record set")
        val statement = Statement().apply {
            this.namespace = namespace
            this.setName = setName
        }

        val recordSet = aerospikeClient.query(QueryPolicy(), statement)
        return recordSet
                .map { it.record.bins }
    }

    fun putRecords(aerospikeRecordRequest: AerospikeRecordRequest) {
        println("Inserting data")
        val key = Key(aerospikeRecordRequest.namespace,
                aerospikeRecordRequest.setName,
                aerospikeRecordRequest.key)

        val binList = aerospikeRecordRequest.data
                .map { (name, value) -> Bin(name, value) }
                .toTypedArray()

        aerospikeClient.put(WritePolicy(), key, *binList)
    }
}