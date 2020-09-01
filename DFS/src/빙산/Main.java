package 빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Map problem = new Map();
		try {
			problem.solution();
		}catch (Exception e) {
			e.printStackTrace();
		} 

	}

	
}

class Map
{
	private int row, col;
	private int afterYear = 0;
	private int map[][];
	private int checkMap[][];
	private ArrayList<Mountin> mountins = new ArrayList<Mountin>();
	private int[] fourDirectionX = {-1, 0, 1, 0};
	private int[] fourDirectionY = {0, 1, 0, -1};
	
	public void solution() throws IOException
	{
		init();		
		while(!mountins.isEmpty())
		{
			nextYear();
			// nextYear() 다음에 mountins가 empty일 수 있음에 주의.
			if(mountins.isEmpty())
			{
				System.out.println(0);
				break;
			}
			
			int x = mountins.get(0).getX();
			int y = mountins.get(0).getY();
			DFS(x, y);
			if(countCheckMap() != mountins.size())
			{
				System.out.println(afterYear);
				break;
			}
			else
			{
				resetCheckMap();				
			}
		}		
	}
	
	public void init() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		try
		{
			String rc[] = (br.readLine()).split(" ");
			row = Integer.parseInt(rc[0]);
			col = Integer.parseInt(rc[1]);
			map = new int[row][col];
			checkMap = new int[row][col];
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < row; i++)
		{
			String line[] = (br.readLine().split(" "));
			for(int j = 0; j < line.length; j++)
			{
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j] != 0)
				{
					mountins.add(new Mountin().setMountin(i, j, map[i][j])); //
				}
			}
		}
		br.close();
	}
	
	public int countCheckMap()
	{
		int count = 0;
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(checkMap[i][j] != 0)
					count++;
			}
		}
		return count;
	}
	
	public void resetCheckMap()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				checkMap[i][j] = 0;
			}
		}
	}
	
	public boolean checkDirection(int x, int y)
	{
		if(0 <= x && x < row && 0 <= y && y < col)
		{
			return true;
		}
		return false;
	}
	
	public void reCheckMountin()
	{
		for(int i = 0; i < mountins.size();)
		{
			int x = mountins.get(i).getX();
			int y = mountins.get(i).getY();
			int height = mountins.get(i).getHeight();
			
			map[x][y] = height;
			
			if(height == 0)
			{
				mountins.remove(i);
			}
			else i++;
		}
	}
	
	public void DFS(int hereX, int hereY)
	{
		for(int l = 0; l < 4; l++)
		{
			int thereX = hereX + fourDirectionX[l];
			int thereY = hereY + fourDirectionY[l];
			
			if(checkDirection(thereX, thereY) && map[thereX][thereY] != 0 && checkMap[thereX][thereY] == 0)
			{
				checkMap[thereX][thereY] = 1;
				DFS(thereX, thereY);
			}
		}
	}
	
	public void nextYear()
	{
		afterYear++;
		for(int i = 0; i < mountins.size(); i++)
		{
			Mountin thisPosition = mountins.get(i);
			int thisX = thisPosition.getX();
			int thisY = thisPosition.getY();
			int count = 0;
			
			for(int l = 0; l < 4; l++)
			{
				int thereX = thisX + fourDirectionX[l];
				int thereY = thisY + fourDirectionY[l];
				
				
				if(checkDirection(thereX, thereY))
				{
					if(map[thereX][thereY] == 0)
					{
						count++;
					}
				}
			}
			
			int thereHeight = map[thisX][thisY] - count;
			if(thereHeight >= 0)
			{
				mountins.set(i, new Mountin().setMountin(thisX, thisY, thereHeight));
			}
			else
			{
				mountins.set(i, new Mountin().setMountin(thisX, thisY, 0));
			}
		}
		
		reCheckMountin();
		
		
	}
	
	public void printMap()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Mountin
{
	private int _x;
	private int _y;
	private int _height;
	
	public void setX(int x) {
		_x = x;
	}
	public void setY(int y) {
		this._y = y;
	}
	public Mountin setMountin(int x, int y, int h)
	{
		this._x = x;
		this._y = y;
		this._height = h;
		
		return this; //
	}
	public int getX()
	{
		return this._x;
	}
	public int getY()
	{
		return this._y;
	}
	public int getHeight()
	{
		return this._height;
	}
}