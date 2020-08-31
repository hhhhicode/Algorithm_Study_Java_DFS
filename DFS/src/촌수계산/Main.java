package 촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Chonsu p = new Chonsu();
		p.solution();
    }
}


class Chonsu {
	private int n, m; // n : 전체 사람의 수, m : 부모 자식들 간의 관계의 개수
	private int resultX, resultY;
	private int isOk = 0;
	private ArrayList<Integer>[] superAndSub;
	private boolean[][] checkNode;
	
	public void solution()
	{
		try
		{
			init();
			search(resultX, 0);
			if(isOk == 0)
			{
				System.out.println(-1);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		try
		{
			n = sc.nextInt();
			superAndSub = new ArrayList[n + 1];
			checkNode = new boolean[n + 1][n + 1];
			resultX = sc.nextInt();
			resultY = sc.nextInt();
			m = sc.nextInt();
			
			for(int i = 0; i < n + 1; i++)
			{
				superAndSub[i] = new ArrayList<>();
			}
			int p, k;
			for(int i = 0; i < m; i++)
			{
				p = sc.nextInt(); k = sc.nextInt();
				superAndSub[p].add(k);
				superAndSub[k].add(p);
			}
			br.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void search(int here, int count)
	{
		if(here == resultY) 
		{
			isOk = 1;
			System.out.println(count);
		}
		
		for(int i = 0; i < superAndSub[here].size(); i++)
		{
			int there = superAndSub[here].get(i);
			
			if(checkNode[here][there] == false)
			{
				checkNode[here][there] = true; // 이부분 
				checkNode[there][here] = true; // 이부분이 중요하다.
				search(there, count + 1);
			}
		}
	}
}