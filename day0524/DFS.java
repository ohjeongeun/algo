import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

	
	static class Node { //��� Ŭ����
		int data; //��� �ε���
		List<Node> neighbors; //��������
		boolean visited;
		
		//Ŭ���� ������
		Node(int data) {
			this.data=data;
			this.neighbors = new ArrayList<>();
		}
		
		public void addneighbors(Node neighborNode) { //��������߰�
			this.neighbors.add(neighborNode);
		}
		
		public List<Node> getNeighbors() { //��������ȯ (��ȯ�� ����Ʈ��)
			return neighbors;
		}
		
		public void setNeighbors(List<Node> neighbors) { //�������set
			this.neighbors=neighbors;
		}
	}
	

	public void dfs(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node); // stack�� v�߰�
		node.visited=true; // �湮 ǥ��

		while(!stack.isEmpty()) {//stack�� ���� ������
			Node v = stack.pop(); //
			System.out.print(v.data+" ");
			
			//�̿��� ����Ʈ
			List<Node> neighbors = v.getNeighbors();
			for(int i=0; i < neighbors.size(); i++) { //�̿�����ŭ
				Node w = neighbors.get(i);
				if(w!=null && !w.visited) {
					stack.add(w);
					w.visited=true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		//��� ����
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node G = new Node(6);
 
		//�̿� ����
		A.addneighbors(B);
		A.addneighbors(C);
		B.addneighbors(D);
		B.addneighbors(E);
		D.addneighbors(F);
		E.addneighbors(F);
		F.addneighbors(G);
 
		DFS dfsExample = new DFS();
		dfsExample.dfs(A);
	}
	

}
