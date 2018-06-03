import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Flattern
public class SW_1208 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); //���� Ƚ��
			
			int a[] = new int[100]; //���ڵ�
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N; j++) {// ���� Ƚ����ŭ �ְ������� ���������� ���� �ű�
				Arrays.sort(a); //�������� ����
				a[99] -= 1; //�ְ���-1
				a[0] += 1;  //������+1
			}
			
			Arrays.sort(a);
			int result=a[99]-a[0];
		
			System.out.println("#"+t+" "+result);
		}

	}

}
