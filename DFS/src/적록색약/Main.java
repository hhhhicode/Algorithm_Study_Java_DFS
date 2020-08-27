package 적록색약;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int N;
	static char[][] rgb;
	static char[][] rb;
	static boolean[][] check;
	static int[] xl = {-1, 0, 1, 0};
	static int[] yl = {0, 1, 0, -1};
	
	public static void main(String[] args) {

		run();		

		sc.close();
	}
	
	static void generateRGB()
	{
		N = sc.nextInt();
		
		rgb = new char[N][N];
		rb = new char[N][N];
		for(int i = 0; i < N; i++)
		{
			String s = sc.next();
			for(int j = 0; j < s.length(); j++)
			{
				rgb[i][j] = s.charAt(j);
				if(rgb[i][j] == 'G')
				{
					rb[i][j] = 'R';
				}
				else
				{
					rb[i][j] = rgb[i][j];
				}
			}
		}
		check = new boolean[N][N];
	}
	
	static void reCheck()
	{
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				check[i][j] = false;
	}

	static void DFS(char[][] rgb, int hereX, int hereY)
	{
		char hereColor = rgb[hereX][hereY];
		
		for(int l = 0; l < 4; l++)
		{
			int thereX = hereX + xl[l];
			int thereY = hereY + yl[l];

			if(0 <= thereX && thereX < N && 0 <= thereY && thereY < N && rgb[thereX][thereY] == hereColor && check[thereX][thereY] == false)
			{
				check[thereX][thereY] = true;
				DFS(rgb, thereX, thereY);
			}
		}
	}
	
	static void run()
	{
		generateRGB();
		
		int countNormal = 0;
		int countUnnormal = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(check[i][j] == false)
				{
					check[i][j] = true;
					DFS(rgb , i, j);
					countNormal++;
				}
			}
		}
		
		reCheck();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(check[i][j] == false)
				{
					check[i][j] = true;
					DFS(rb , i, j);
					countUnnormal++;
				}
			}
		}
		System.out.println(countNormal + " " + countUnnormal);
	}
}
