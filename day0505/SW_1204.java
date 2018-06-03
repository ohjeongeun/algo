import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// �ֺ�� ���ϱ�
public class SW_1204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			int cnt[] = new int[101]; // cnt�迭�� index�� ����(0~100)
			StringTokenizer st = new StringTokenizer(br.readLine());
			int score=0;
			for(int i=0; i<1000; i++) {
				score = Integer.parseInt(st.nextToken());
				cnt[score]++;
			}
			
			int max=0;
			int maxscore=0;
			for(int j=0; j<101; j++) {
				if(cnt[j]>=max) { //�ֺ�� ������ ���������� ���� ū ���� ����ؾ��ϱ� ������ ��ȣ �ʿ�
					max = cnt[j]; //score�� 0���� 100�϶����� �ֺ���� ã�� max������ ����
					maxscore = j; //�׶��� score maxscore�� ����
				}
			}
			
			System.out.println("#"+T+" "+maxscore);
		}

	}

}
