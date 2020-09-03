package ≈“_«¡∑Œ¡ß∆Æ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Classify c = new Classify();
		c.solution();
	}

}

class Classify {
	private int _t;
	private int _n;
	private int count;
	private int[] list;
	private int[] check;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void solution() {
		int t = 0;
		try {
			t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++) {
				init();
				count = 0;
				for(int j = 1; j <= _n; j++) {
					if(check[list[j]] != 1) {
						if(circulator(j, j) != j) {
							count++;
						}
					}
				}
				System.out.println(count);
				reCheck();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void init() {
		
		try {
			_n = Integer.parseInt(br.readLine());
			
			list = new int[_n + 1];
			check = new int[_n + 1];
			String[] s = br.readLine().split(" ");

			for(int i = 1; i <= _n; i++) {
				list[i] = Integer.parseInt(s[i - 1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int circulator(int seed, int here) {
		int there = list[here];
		if(check[there] != 1) {	
			check[there] = 1;		
			list[here] = circulator(seed, there); //
			if(seed != list[here])
				check[there] = 0;
		}	
		
		return list[here]; //
	}
	
	public void reCheck() {
		for(int i = 1; i <= _n; i++)
			check[i] = 0;
	}
}
