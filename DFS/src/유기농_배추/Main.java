package ¿Ø±‚≥Û_πË√ﬂ;

import java.util.Scanner;

public class Main {

	static int T;
	static int M, N;
	static int K;
	static int[] xl = {-1,0,1,0}, yl = {0,1,0,-1};
	static int[][] map;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		T = sc.nextInt();
		while(T-- != 0)
		{
			int count = 0;
			
			generateMap();
	
			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(map[i][j] != 0)
					{
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	
	static void generateMap()
	{
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[M][N];
		int x, y;
		for(int i = 0; i < K; i++)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			map[x][y] = 1;
		}
	}

	static void DFS(int hereX, int hereY)
	{
		map[hereX][hereY] = 0;
		for(int l = 0; l < 4; l++)
		{
			int thereX = hereX + xl[l];
			int thereY = hereY + yl[l];
			
			if(0 <= thereX && thereX < M && 0 <= thereY && thereY <N && map[thereX][thereY] != 0)
			{
				DFS(thereX, thereY);
			}
		}
	}
}
