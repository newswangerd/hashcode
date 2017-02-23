package main;

import java.io.*;

public class YoutubeOptimization {
	private int[] videos;
	private Endpoint[] endpoints;
	private int[] requests;
	
	private int V, E, R, C, X;
	
	public static void main(String []args) throws IOException{
		YoutubeOptimization o = new YoutubeOptimization();
	}
	
	public YoutubeOptimization() throws IOException{
		String workingDirectory = System.getProperty("user.dir");
		LoadData(workingDirectory + "/src/kittens.in");
		System.out.println("loaded data");
		
	}
	
	public void LoadData(String filename) throws IOException{
		FileInputStream in = null;
		BufferedReader br = new BufferedReader(new FileReader(filename));  
		String line = null;  
		
		// get v, e, r, c, x
		
		line = br.readLine();
		String[] first = line.split(" ");
		
		V = Integer.parseInt(first[0]);
		E = Integer.parseInt(first[1]);
		R = Integer.parseInt(first[2]);
		C = Integer.parseInt(first[3]);
		X = Integer.parseInt(first[4]);
		
		videos = new int[V];
		endpoints = new Endpoint[E];
		requests = new int[R];
		
		line = br.readLine();
		
		String[] vids = line.split(" ");
		
		for (int i = 0; i < V; i ++){
			videos[i] = Integer.parseInt(vids[i]);
		}
				
		for (int i = 0; i < E; i ++){
			line = br.readLine();
			String[] vals = line.split(" ");
			
			int latency = Integer.parseInt(vals[0]);
			int num_caches = Integer.parseInt(vals[1]);
			
			this.endpoints[i] = new Endpoint(latency, num_caches);
			
			for (int j = 0; j < num_caches; j++){
				line = br.readLine();
				String[] cache_data = line.split(" ");
				this.endpoints[i].addCache(Integer.parseInt(cache_data[0]), Integer.parseInt(cache_data[1]));
				
			}
		}
		
		for (int i = 0; i < R; i++){
			line = br.readLine();
			String[] vals = line.split(" ");
			int end_id = Integer.parseInt(vals[1]);
			this.endpoints[end_id].addRequest(Integer.parseInt(vals[0]), Integer.parseInt(vals[2]));
		}
	}
}
