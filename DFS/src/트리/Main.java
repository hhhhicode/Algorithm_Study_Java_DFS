// 틀린 문제
// 자식이 지워져서 부모가 leaf가 될 수도 있다.
//2
//-1 0
//1

package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Problem p = new Problem();
		p.solution();
	}

}

class Problem {
	private int _n;
	private int _cutNode;
	private int _leafNode = 0;
	private ArrayList<Integer>[] _array;
	private boolean _check[];
	
	public void solution() {
		init();
		DFS(_cutNode);
		leafCheck();
		System.out.println(_leafNode);
	}
	
	public void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			_n = Integer.parseInt(br.readLine());
			
			_array = new ArrayList[_n];
			_check = new boolean[_n];
			for(int i = 0; i < _n; i++) {
				_array[i] = new ArrayList<Integer>();
			}
			
			String s[] = br.readLine().split(" ");
			int parentNode;
			for(int thisNode = 0; thisNode < s.length; thisNode++) {
				parentNode = Integer.parseInt(s[thisNode]);
				if(parentNode != -1) {
					_array[parentNode].add(thisNode);
				}
			}
			
			_cutNode = Integer.parseInt(br.readLine());
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void DFS(int cutNode) {
		_check[cutNode] = true;
		for(int i = 0; i < _array[cutNode].size(); i++) {
			int childNode = _array[cutNode].get(i);
			DFS(childNode);
		}
	}
	
	public void leafCheck() {
		for(int i = 0; i < _n; i++) {
			int Node = 0;
			if(_check[i] == false) {
				for(int j = 0; j < _array[i].size(); j++) {
					int child = _array[i].get(j);
					if(_check[child] == false) {
						Node++;
					}
				}
				if(Node == 0) {
					_leafNode++;
				}
			}
		}
	}
}
