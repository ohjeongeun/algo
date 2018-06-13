package day0614;

import java.util.LinkedList;
import java.util.Scanner;

public class SW_1229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			
			//���� ��ȣ���� ����
			int len = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0; i<len; i++) {
				list.add(sc.nextInt());
			}
			
			//��ɹ� ����
			int n = sc.nextInt();
			
			int x=0; int y=0;
			for(int i=0; i<n; i++) {
				String s = sc.next();
				
				if(s.equals("I")) { //����
					x = sc.nextInt();
					y = sc.nextInt();
					for(int j=0; j<y; j++) {
						list.add(x+j, sc.nextInt());
					}
					
				}else if(s.equals("D")) { //����
					x = sc.nextInt();
					y = sc.nextInt();
					for(int j=0; j<y; j++) {
						list.remove(x);
					}
				}
				
			}
			
			System.out.print("#"+t);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.removeFirst());
			}
			System.out.println();
		
		}
		
	}

}
