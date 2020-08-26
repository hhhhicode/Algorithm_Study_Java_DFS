package ¾ËÆÄºª;

import java.util.Scanner;

public class Main {

	static int R, C;
	static int[][] map;
	static boolean[] ch = new boolean[(int)'Z' + 1];
	static int[] xl = {-1, 0, 1, 0};
	static int[] yl = {0, 1, 0, -1};
	static int maxCount = 1;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {


		generateMap();
		
		DFS(1, 1, 1);
		
		System.out.println(maxCount);
	}

	static void generateMap()
	{
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R + 1][C + 1];
		
		try
		{
			for(int i = 1; i <= R; i++)
			{
				String s = sc.next();
				for(int j = 0; j < s.length(); j++)
				{
					map[i][j + 1] = (int)s.charAt(j) - 64;				
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ch[map[1][1]] = true;
	}
	
	static void DFS(int hereX, int hereY, int count)
	{
		if(maxCount < count) maxCount = count;
		for(int l = 0; l < 4; l++)
		{
			int thereX = hereX + xl[l];
			int thereY = hereY + yl[l];
			
			if(1 <= thereX && thereX <= R && 1 <= thereY && thereY <= C && ch[map[thereX][thereY]] == false)
			{
				int thereChar = map[thereX][thereY];
				ch[thereChar] = true;
				DFS(thereX, thereY, count + 1);
				ch[thereChar] = false;
			}
		}
	}
}
