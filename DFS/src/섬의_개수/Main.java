package ¼¶ÀÇ_°³¼ö;

import java.util.Scanner;

public class Main {

	static int[] xl = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] yl = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int W = -1, H = -1;
	static int[][] map;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		while(true)
		{
			int count = 0;
			H = sc.nextInt();
			W = sc.nextInt();
			if(W == 0 && H == 0)
				break;
			map = generateMap();
			for(int i = 0; i < W; i++)
			{
				for(int j = 0; j < H; j++)
				{
					if(map[i][j] == 1)
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

	static int[][] generateMap()
	{
		int[][] m = new int[W][H];
		for(int i = 0; i < W; i++)
		{
			for(int j = 0; j < H; j++)
			{
				m[i][j] = sc.nextInt();
			}
		}
		return m;
	}
	
	static void DFS(int hereX, int hereY)
	{
		map[hereX][hereY] = 0;
		for(int i = 0; i < 8; i++)
		{
			int thereX = hereX + xl[i];
			int thereY = hereY + yl[i];
			
			if(0 <= thereX && thereX < W && 0 <= thereY && thereY < H && map[thereX][thereY] == 1)
			{
				DFS(thereX, thereY);
			}
		}
	}
}
