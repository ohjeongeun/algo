import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1213 {

	static int T;
	static String pattern;
	static String str;
	static String p[];
	static String s[];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; t++ ) {
			T = Integer.parseInt(br.readLine());
			pattern = br.readLine();
			str = br.readLine();
			
			p = new String[pattern.length()];
			s = new String[str.length()];
			
			for(int i=0; i<p.length; i++) {
				p[i] = Character.toString(pattern.charAt(i));
			}
			
			for(int i=0; i<s.length; i++) {
				s[i] = Character.toString(str.charAt(i));
			}

			cnt=0;
			boolean flag;
			for(int i=p.length-1; i<s.length; i++) {
				flag=false;
				if(s[i].equals(p[p.length-1])) { //���� �� �����ڿ� ������
					flag=true;
					for(int j=p.length-2; j>=0; j--) { //�״������ڵ鵵 ���� ��
						i--;
						if(s[i].equals(p[j])) {
							flag=true;
						}else {
							i+=2;
							flag=false;
							break;
						}
					}
					if(flag==true) {
						cnt++;
						i+=p.length;
						continue;
					}

				}else { //���������� ��ŭ �̵��Ҳ���?			
					if(pattern.contains(s[i])) { //���� �����ڿ� �ٸ����� ���Ͽ� ���Ե�������

						i += p.length-1-pattern.indexOf(s[i]);
						i--;
						flag=false;
						continue;
					}else {
						i += p.length;
						i--;
						flag=false;
						continue;
					}
				}
		
			}

			System.out.println("#"+T+" "+cnt);
		}

	}

}
