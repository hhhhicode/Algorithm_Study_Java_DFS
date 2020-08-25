package 영역_구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int M, N, K; // M : 행의 수, N : 열의 수, K : 직사각형의 수
	static int area = 0, count = 0;
	
	static int[][] map;
	static boolean[][] ch;
	
	static int[] xl = {-1,0,1,0};
	static int[] yl = {0,1,0,-1};
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		generateMap();
		
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[i][j] == 0 && ch[i][j] == false)
				{
					findBlank(i, j);
					list.add(area);
					area = 0;
					count++;
				}
			}
		}

		Collections.sort(list);
		
		System.out.println(count);
		for(int idx : list)
		{
			System.out.print(idx + " ");
		}
	}

	static void generateMap()
	{
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[M][N];		
		for(int i = 0; i < K; i++)
		{
			int x1, y1, x2, y2;
			x1 = sc.nextInt();	y1 = sc.nextInt();
			x2 = sc.nextInt();	y2 = sc.nextInt();
			
			for(int _x = x1; _x < x2; _x++)
			{
				for(int _y = y1; _y < y2; _y++)
				{
					map[_y][_x] = 1;
				}
			}
		}
		
		ch = new boolean[M][N];
	}
	
	static void findBlank(int hereX, int hereY)
	{
		area++;
		ch[hereX][hereY] = true;
		
		for(int l = 0; l < 4; l++)
		{
			int thereX, thereY;
			thereX = hereX + xl[l];
			thereY = hereY + yl[l];
			
			if(0 <= thereX && thereX < M && 0 <= thereY && thereY < N && map[thereX][thereY] == 0 && ch[thereX][thereY] == false)
			{
				findBlank(thereX, thereY);
			}
		}
	}
}
