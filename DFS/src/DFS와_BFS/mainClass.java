package DFS¿Í_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mainClass {
	static int N;
	static int M;
	static int V;
	static int[][] adj;
	static int[] node;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		
		node = new int[N + 1];
		for(int i : node)
		{
			i = 0;
		}
		
		adj = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++)
		{
			int a, b;
			a = scan.nextInt();
			b = scan.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		
		q = new LinkedList<Integer>();
		
		node[V] = 1;
		q.add(V);
		DFS(0, V);
		System.out.println();
		reLoad();
		node[V] = 1;
		BFS();
	}
	public static void DFS(int n, int v)
	{
		if(n == N)
		{
			return;
		}
		
		System.out.print(v + " ");
		for(int i = 1; i <= N; i++)
		{
			if(adj[v][i] == 1 && node[i] == 0)
			{
				node[i] = 1;				
				DFS(n + 1, i);
			}
		}
	}
	
	public static void BFS()
	{
		while(!q.isEmpty())
		{
			int here = q.poll();
			System.out.print(here + " ");
			for(int i = 1; i <= N; i++)
			{
				if(adj[here][i] == 1 && node[i] == 0)
				{
					node[i] = 1;
					q.add(i);
				}
			}
		}
	}
	
	public static void reLoad()
	{
		for(int i = 0; i < node.length; i++)
			node[i] = 0;
	}
}
