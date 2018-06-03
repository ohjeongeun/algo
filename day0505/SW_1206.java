import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// View
public class SW_1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); //Testcase ����
			
			StringTokenizer st = new StringTokenizer(br.readLine()); //Testcase �޾Ƽ� ��������� �ɰ�
			int a[] = new int[N]; //Testcase ���� �迭
			
			for(int i=0; i<a.length; i++) { //Testcase �迭�� data ����
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int view=0; //������ 
			for(int i=2; i<a.length-2; i++) { //�ǹ��� �������� ���� �ǿ��� ��ĭ, �ǿ����� ��ĭ�� �񱳿��� ����
				
				int left=0; 
				int right=0; 
				
				//�� ������
				if(a[i]>a[i-2] && a[i]>a[i-1]) {
					left= a[i] - Math.max(a[i-1], a[i-2]);
					//System.out.print(left+"�� ");
				}
				
				//�� ������
				if(a[i]>a[i+2] && a[i]>a[i+1]) {
					right = a[i] - Math.max(a[i+1], a[i+2]);
					//System.out.print(right+"�� ");
				}
				
				if(left>right) { //��, �� ������ �� "���� ������"���� ��Ƴ���
					view += right; //��Ƴ��� �������� �����Ǻ��� view�� ������
				}else {
					view += left;
				}
			}
			//System.out.println();
			System.out.println("#"+t+" "+view);
			
		}
	}
}
