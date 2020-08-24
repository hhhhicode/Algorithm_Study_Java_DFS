package 안전_영역;

import java.util.Scanner;

public class Main {

	static int N;
	static int maxHeight = 0;
	static int[] xl = {-1, 0, 1, 0};
	static int[] yl = {0, 1, 0, -1};
	static int[][] scope;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		N = sc.nextInt();
		scopeBuilder(N);
		int maxCount = 0;
		for(int i = 0; i <= maxHeight; i++)
		{
			int count = 0;
			for(int m = 0; m < N; m++)
			{
				for(int n = 0; n < N; n++)
				{
					if(i < scope[m][n])
					{
						DFS(i, m, n);
						count++;
					}
				}
			}
			for(int m = 0; m < N; m++)
			{
				for(int n = 0; n < N; n++)
				{
					if(scope[m][n] < 0)
					{
						scope[m][n] *= -1;
					}
				}
			}
			if(maxCount < count)
				maxCount = count;
		}
		
		System.out.println(maxCount);
		sc.close();
	}

	static void scopeBuilder(int N)
	{
		scope = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				scope[i][j] = sc.nextInt();
				if(maxHeight < scope[i][j])
					maxHeight = scope[i][j];
			}
		}
	}
	
	static void DFS(int i, int hereX, int hereY)
	{
		scope[hereX][hereY] *= -1;
		for(int l = 0; l < 4; l++)
		{
			int thereX = hereX + xl[l];
			int thereY = hereY + yl[l];
			if(0 <= thereX && thereX < N && 0 <= thereY && thereY < N && i < scope[thereX][thereY])
			{
				DFS(i, thereX, thereY);
			}
		}
	}
}
