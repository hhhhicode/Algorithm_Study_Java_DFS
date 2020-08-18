package 단지번호붙이기;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	
	static int[] xl = {-1,0,1,0};
	static int[] yl = {0,1,0,-1};
	static Scanner scan = new Scanner(System.in);
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		N = scan.nextInt();
		map = GenerateMap();
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[i][j] == 1)
				{
					searchGroup(i, j);
					resultList.add(result);
					result = 0;
				}
			}
		}
		
		Collections.sort(resultList);
		System.out.println(resultList.size());
		for(Integer a : resultList)
		{
			System.out.println(a);
		}
	}
	
	static public int[][] GenerateMap()
	{
		int[][] tmp = new int[N][N];
		char[] c = new char[N];
		String s;
		for(int i = 0; i < N; i++)
		{
			s = scan.next();
			c = s.toCharArray();
			
			for(int j = 0; j < N; j++)
			{
				tmp[i][j] = Integer.parseInt("" + c[j]);
			}
		}
		return tmp;
	}
	
	static public void searchGroup(int hereX, int hereY)
	{
		map[hereX][hereY] = 0;
		result++;
		for(int k = 0; k < 4; k++)
		{
			int thereX = hereX + xl[k];
			int thereY = hereY + yl[k];
			
			if(0 <= thereX && thereX < N && 0 <= thereY && thereY < N)
			{
				if(map[thereX][thereY] == 1)
				{
					searchGroup(thereX, thereY);
				}
			}
		}
		
	}

}
