package main;

import java.util.*;

public class Endpoint {
	int latency;
	int num_caches;
	Map <Integer, Integer> caches;
	Map <Integer, Integer> requests;
	
	public Endpoint(int l, int n){
		this.latency = l;
		this.num_caches = n;
		this.caches = new <Integer, Integer> HashMap();
		this.requests = new <Integer, Integer> HashMap();
	}
	
	public void addCache(int id, int latency){
		this.caches.put(id, latency);
	}
	
	public void addRequest(int id, int requests){
		this.requests.put(id, requests);
	}
}
