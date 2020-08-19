package 연결_요소의_개수;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int N, M;
	static int[] node;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		node = new int[N + 1];
		for(int i = 0; i < N + 1; i++)
		{
			node[i] = i;
		}
		
		for(int i = 0; i < M; i++)
		{
			int u, v;
			u = sc.nextInt();
			v = sc.nextInt();
			
			Union(u, v);
		}
		
		System.out.println(countGroup());
		sc.close();
	}

	static void Union(int u, int v)
	{
		u = Find(u);
		v = Find(v);
		if(u != v)
		{
			node[u] = v;
		}
	}
	static int Find(int n)
	{
		if(node[n] == n) return n;
		return node[n] = Find(node[n]);
	}
	
	static int countGroup()
	{
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 1; i < N + 1; i++)
		{
			s.add(Find(i));
		}
		return s.size();
	}
}