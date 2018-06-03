import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixtoPostfix {

	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
		
		String infix = "( 5 + 4 * ( 1 - 7 ) / 1 )";
		StringTokenizer st = new StringTokenizer(infix);
		
		//Stack ���� ���� �� ������ �켱���� : ��->��
		HashMap<String, Integer> inP = new HashMap<String, Integer>();
		inP.put("(", 0); // ���� ��ȣ�� ���� ���� ���� �� �켱���� ���� ����
		inP.put("+", 1); // ���� � �����ڵ� ���� ���� �� ����
		inP.put("-", 1);
		inP.put("*", 2);
		inP.put("/", 2);
		
		//Stack �ۿ����� ������ �켱���� : ��->��
		HashMap<String, Integer> outP = new HashMap<String, Integer>();
		outP.put("+", 1);
		outP.put("-", 1);
		outP.put("*", 2);
		outP.put("/", 2);
		outP.put("(", 3);

		//��� �迭
		ArrayList<String> arr = new ArrayList<String>(); 

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			// ��ū�� ���ʰ�ȣ �� ������
			if(token.equals("(") || token.equals("/") || token.equals("*") || token.equals("-") || token.equals("+")) {
				
				//������ ���������
				if(myStack.isEmpty()) {
					myStack.push(token);
				
				//���� ������� ������
				}else {
					
					// �켱���� : top < token
					if(inP.get(myStack.peek()) < outP.get(token)) {
						myStack.push(token);
					
					}else {
					// �켱���� : top > token
						while(true) {
							if(inP.get(myStack.peek()) < outP.get(token)) {
								myStack.push(token);
								break;
							} // �켱���� : top < token �ɶ����� Stack pop
							arr.add(myStack.pop());
						}
					}
					
				}
			// ��ū�� ������ ��ȣ	
			} else if(token.equals(")")) {
				while(true) {
					if(myStack.peek().equals("(")) {
						myStack.pop();
						break;
					}
					arr.add(myStack.pop());
				}
				
			// ��ū�� ����	
			} else {
				arr.add(token);
			}
			

			
		}
		if(!st.hasMoreTokens()) {
			while(true) {
				if(myStack.isEmpty()) {
					break;
				}
				
				arr.add(myStack.pop());	
			}
			
		}
		
		System.out.println(arr);
		
		int len = arr.size();
		Stack<Integer> sum =  new Stack<Integer>();
		
		int i=0;
		while(i<len) {
			int p; int q;
			
			if(arr.get(i).equals("+")) {
				q = sum.pop();
				p = sum.pop();	
				sum.add(p+q);
				
			}else if(arr.get(i).equals("-")) {
				q = sum.pop();
				p = sum.pop();	
				sum.add(p-q);
				
			}else if(arr.get(i).equals("*")) {
				q = sum.pop();
				p = sum.pop();	
				sum.add(p*q);
				
			}else if(arr.get(i).equals("/")) {
				q = sum.pop();
				p = sum.pop();	
				sum.add(p/q);
					
			}else {
				sum.add(Integer.parseInt(arr.get(i)));				
			
			}
			
			i++;
		}
	
		System.out.println(sum);
	

	}

}
