package zDay0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210 {
	static int T;
	static int map[][];
	static int N=100;
	static int visited[][];
					 // ��  ��   �� 
	static int dx[] = {-1, 1, 0};//j
	static int dy[] = {0, 0, 1};//i
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			flag=false;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.print("#"+T+" ");
			for(int p=0; p<N; p++) {
				visited = new int[N][N];
				flag=false;
				
				solve(0, p);
				
				if(flag==true) {
					System.out.println(p);
					break;
				}
				
			}
					
		}

	}

	static int curx; static int cury;
	public static void solve(int cury, int curx) {
		if(map[cury][curx]==0) { //������� 0�̸� ����
			flag=false;
			return ;
		}
		
		for(int y=cury; y<N; y++) {
			for(int x=curx; x<N; x++) {
				if(map[y][x]==1 && visited[y][x]!=1) {//���̰� �湮x��
					visited[cury][curx]=1; //�湮
		
					}
				
				for(int d=0; d<3; d++) { //���� �湮 Ž��
					//  ��                                   ��                                      ��                                   ��
					if(cury+dy[d]<0 || cury+dy[d]>N-1 || curx+dx[d]<0 || curx+dx[d]>N-1) {//�� ���⿡�� ��輱�� �ɸ��� ������������ continue
						continue;
					}
					if(map[cury+dy[d]][curx+dx[d]]==0 || visited[cury+dy[d]][curx+dx[d]]==1) { //���������� ���� �ƴϰų� �湮�߾����� continue
						continue;
					}
					if(map[cury+dy[d]][curx+dx[d]]==1 || map[cury+dy[d]][curx+dx[d]]==2) { //���� ������ ���̸� or ��������
						cury += dy[d];
						curx += dx[d];	
						visited[cury][curx]=1;
						y=cury; 
						x=curx-1; //x=9�� ��� ���ʱ��� �־ ��ã�� y++�� �Ѿ����
						break;
						}
					}
				
				if(cury==N-1 && map[cury][curx]!=2) { //����
					flag=false;
					return ;
				}
				if(cury==N-1 && map[cury][curx]==2) { //����
					flag=true;
					return ;
				}
			}
		}	
	}
}
