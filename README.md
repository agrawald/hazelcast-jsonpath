hazelcast-jsonpath

Application uses JsonPath to store raw json in Hazelcast Data Grid and search for a specific value in the json string.
The hazelcast collection is indexing the collection with the value we want to search for using ValueExtractor and MapConfig.

Following is the stats

Data Set: {"name":"dummy1"}
Number of records: 1000000 of 24Mb

Time to save: 30.191 sec
Time to retrieve one value with name = dummy999999: 7ms