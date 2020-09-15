// 오버타임

package 효율적인_해킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Problem p = new Problem();
		p.solution();
	}

}

class Problem {
	
	int N, M, max = 0;
	int count = 1;
	private ArrayList<Integer>[] adj = null;
	private int[] ch = null;
	private int[] costList = null;
	
	public void solution() {
		init();
		for(int i = 1; i <= N; i++) {
			//if(ch[i] != 0) continue; //
			DFS(i, i);
		}
		for(int i : costList)
			if(max < i) max = i;
		for(int i = 1; i <= N; i++) {
			if(max == costList[i]) {
				System.out.print(i + " ");
			}
		}
	}
	public void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s[] = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			costList = new int[N + 1];
			ch = new int[N + 1];
			adj = new ArrayList[N + 1];
			for(int i = 0; i <= N; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				s = br.readLine().split(" ");
				int there, here;
				here = Integer.parseInt(s[0]); // 찾고자 하는것에 변화를 줄 수 있도록...?  가장 많이 지나간 곳이 가장 많은 컴퓨터를 해킹 가능한 곳.
				there = Integer.parseInt(s[1]); // 찾는건 모체이므로 Super -> Sub이 아니라 Sub -> Super로 도달할 수 있게...
				
				adj[here].add(there);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DFS(int seed, int here) {
		ch[here] = seed;
		for(int there : adj[here]) {
			if(ch[there] != seed) {
				DFS(seed, there);
				costList[there]++; // <- 이곳이 크게 문제였다. costList[seed]++;  
			}
		}
	}
}
