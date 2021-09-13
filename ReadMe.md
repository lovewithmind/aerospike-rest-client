# Query Data

curl --location --request GET 'http://localhost:8085/aql/query' \
--header 'namespace: test' \
--header 'setName: myset'

# Fetch Data

curl --location --request POST 'http://localhost:8085/aql/put' \
--header 'Content-Type: application/json' \
--data-raw '  {
"namespace": "test",
"setName": "myset3",
"key": "MMMM",
"data": [
{
"name": "someData",
"value": "someValue"
}
]
}'