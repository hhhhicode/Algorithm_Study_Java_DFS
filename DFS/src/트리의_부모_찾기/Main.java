package 트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Tree t = new Tree();
		t.solution();	

	}

}

class Tree {
	
	private int n;
	private int[] nPList;
//	private int[][] nodes;
	private ArrayList<Integer> arr[];
	
	public void solution()
	{
		init();
		searchParentNode(1);
		printPList();
	}
	
	public void init() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
//			nodes = new int[n + 1][n + 1];
			nPList = new int[n + 1];	nPList[1] = 1;
			arr = new ArrayList[n + 1];
			for(int i = 1; i < n + 1; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < n - 1; i++) {
				String s[] = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				
//				nodes[a][b] = 1;
//				nodes[b][a] = 1;
				arr[a].add(b);
				arr[b].add(a);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void searchParentNode(int pNode)
	{
		for(int i : arr[pNode]) {
			if(nPList[i] == 0) {
				nPList[i] = pNode;
				searchParentNode(i);
			}
		}
	}
	
	public void printPList() {
		for(int i = 2; i <= n; i++) {
			System.out.println(nPList[i]);
		}
	}
}
