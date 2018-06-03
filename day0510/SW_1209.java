package zDay0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1209 {
	static int T;
	static int mat[][];
	static int rsum; //������
	static int csum; //������
	static int dsum1; //�޴밢����
	static int dsum2; //�����밢����
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			int N = 100;
			mat = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max=0;
			
			for(int i=0; i<N; i++) {
				csum=0; rsum=0; //�������� �� �ึ��, �������� �� ������ �ʱ�ȭ
				for(int j=0; j<N; j++) {
					csum += mat[i][j];
					rsum += mat[j][i];
				}
				if(csum>max) { //max>csum�̸� max�� csum ����
					max=csum;
				}
				if(rsum>max) { //max>rsum�̸� max�� rsum ����
					max=rsum;
				}
				
			}
			
			dsum1=0; dsum2=0;
			for(int i=0; i<N; i++) {
				dsum1+=mat[i][i];
				dsum2+=mat[i][N-1-i];
			}
			if(dsum1>max) { //max>dsum1�̸� max�� dsum1 ����
				max=dsum1;
			}
			if(dsum2>max) { //max>dsum2�̸� max�� dsum2 ����
				max=dsum2;
			}
			
		
		System.out.println("#"+T+" "+max);

			
		}
	}
}
