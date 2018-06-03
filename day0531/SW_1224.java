import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1224 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			Stack<String> myStack = new Stack<String>();
			
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			//StringTokenizer st = new StringTokenizer(infix);
			
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
			int n=0;
			
			while(n<N) {
				String token = Character.toString(infix.charAt(n));
				
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
				
				n++;
				
			}
			
			if(n==N) {
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

}
