package day0602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1223 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			Stack<String> myStack = new Stack<String>();
			
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			//StringTokenizer st = new StringTokenizer(infix);
			
			//������ �켱���� : ��->��
			HashMap<String, Integer> Pri = new HashMap<String, Integer>();
			Pri.put("+", 1);
			Pri.put("*", 2);
		
			//��� �迭
			ArrayList<String> arr = new ArrayList<String>(); 
			int n=0;
			
			while(n<N) {
				String token = Character.toString(infix.charAt(n));
				
				// 1. ��ū�� + or *
				if(token.equals("*") || token.equals("+")) {
					
					//������ ���������
					if(myStack.isEmpty()) {
						myStack.push(token);
					
					//���� ������� ������
					}else {
						
						
						// �켱���� : top <= token
						if(Pri.get(myStack.peek()) <= Pri.get(token)) {
							myStack.push(token);
						
						}else {
						// �켱���� : top > token
							while(true) {
								if(Pri.get(myStack.peek()) <= Pri.get(token)) {
									myStack.push(token);
									break;
								} // �켱���� : top <= token �ɶ����� Stack pop
								arr.add(myStack.pop());
							}
						}
						
					}
				
					// 2. ��ū�� ����
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
					
				}else if(arr.get(i).equals("*")) {
					q = sum.pop();
					p = sum.pop();	
					sum.add(p*q);
					
				}else {
					sum.add(Integer.parseInt(arr.get(i)));				
				
				}
				
				i++;
			}
		
			System.out.println("#"+t+" "+sum.peek());
			
		}
		
	}

}
