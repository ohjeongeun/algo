import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int data[] = new int[8];
		for(int i=0; i<data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	
		//cnt[]�� �迭�� ���̴� data[i]�� �� �ִ�.
		int max=0;
		for(int i=0; i<data.length; i++) {
			if(data[i]>max) {
				max = data[i];
			}
		}
		
		int cnt[] = new int[max+1]; 
		int tmp[] = new int[8]; //���ĵ� array
		
		//data[i]�� ���� cnt[]�迭�� ����
		for(int i=0; i<data.length; i++) {
			cnt[data[i]]++;
		}
		
		//cnt[i]�� �� �׸��� �տ� ��ġ�� �׸��� ���� �ݿ��ϱ� ���� 
		//�� ���� �����Ͽ� ǥ��.
		for(int i=1; i<cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		//����
		for(int i=data.length-1; i>=0; i--) {
			cnt[data[i]] -= 1;
			tmp[cnt[data[i]]] = data[i];
		}
		
		//���� �� data�迭
		System.out.println();
		for(int i=0; i<tmp.length; i++) {
			System.out.print(tmp[i]+" ");
		}
	
	}
}
