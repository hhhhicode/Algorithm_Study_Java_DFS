// 못풀겠다. 찾아봐야겠다.

package 트리의_지름;

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
	private int v;
	private int maxWeight = 0;
	private int maxPoint;
	private ArrayList<Pair>[] arr_adj = null;
	private boolean[] ch = null;
	
	public void solution() {
		
		init();
		ch[1] = true;
		DFS(0, 1);
		ch[1] = false;
		ch[maxPoint] = true;
		DFS(0, maxPoint);
		System.out.println(maxWeight);
	}
	
	public void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			v = Integer.parseInt(br.readLine());
			arr_adj = new ArrayList[v + 1];
			for(int i = 0; i < arr_adj.length; i++) {
				arr_adj[i] = new ArrayList<Pair>();
			}
			ch = new boolean[v + 1];
			
			for(int i = 0; i < v; i++) {
				String line[] = br.readLine().split(" ");
				int thisNode = Integer.parseInt(line[0]);
				int thereNode, cost;
				for(int j = 1; j < line.length - 1;)
				{
					thereNode = Integer.parseInt(line[j++]);
					cost = Integer.parseInt(line[j++]);
					arr_adj[thisNode].add(new Pair(thereNode, cost));
				}
			}			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 흠...
	public void DFS(int hereCost, int here) {
		if(maxWeight < hereCost) {
			maxWeight = hereCost;
			maxPoint = here;
		}
		for(int i = 0; i < arr_adj[here].size(); i++) {
			Pair thereNode = arr_adj[here].get(i);
			int there = thereNode.getThere();
			int thereCost = thereNode.getCost();
			if(ch[there] == false) {
				ch[there] = true;
				DFS(hereCost + thereCost, there);
				ch[there] = false;				
			}
		}
	}
}
class Pair {
	private int there;
	private int cost;
	
	public Pair(int t, int c) {
		this.there = t;
		this.cost = c;
	}
	
	public int getThere() {
		return this.there;
	}
	public int getCost() {
		return this.cost;
	}
}

