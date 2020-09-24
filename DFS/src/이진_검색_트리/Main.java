// 틀린 문제

package 이진_검색_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Problem p = new Problem();
		p.facade();
	}

}
class Node {
	private int value;
	
	private Node lt = null;
	private Node rt = null;
	
	public Node(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public Node getLt() {
		return lt;
	}
	public Node getRt() {
		return rt;
	}
	public void setLt(Node n) {
		this.lt = n;
	}
	public void setRt(Node n) {
		this.rt = n;
	}
	public void printValue() {
		System.out.println(this.value);
	}
}
class Problem {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Node ll = null;
	
	public void facade() {
		generateTree();
		searching(ll);
	}
	
	public Node DFS(Node ll, int value) {
		if(ll == null) {
			ll = new Node(value);
			return ll;
		}
		else if(ll.getValue() > value) {
			ll.setLt(DFS(ll.getLt(), value));
		}
		else {
			ll.setRt(DFS(ll.getRt(), value));
		}
		return ll;
	}
	public void generateTree() {
		String strLine = null;
		try {
			ll = new Node(Integer.parseInt(br.readLine()));
			while((strLine = br.readLine()) != null) {
				int value = Integer.parseInt(strLine);
				ll = DFS(ll, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void searching(Node ll) {
		if(ll == null) return;
		searching(ll.getLt());
		searching(ll.getRt());
		ll.printValue();
	}
}
