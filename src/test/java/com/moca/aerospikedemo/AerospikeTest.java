package com.moca.aerospikedemo;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.WritePolicy;

public class AerospikeTest {
	
	
	AerospikeClient as = new AerospikeClient("192.168.31.30", 3000);
	WritePolicy writePolicy = new WritePolicy();
	Key key = new Key("test", "cache", "9b26b93f-92a1-157d-8daa-81579f6be2c5");
	
	@Before
	public void before() {
		System.out.println("before test");
	}

	@Test
	public void write() {
		Bin bin = new Bin("myBin", "myValue");
		Bin bin2 = new Bin("Bin2", "value2");
		as.put(writePolicy, key, bin);
	}
	@Test
	public void get() {
		System.out.println(as.get(null, key).toString());
	}
}
