public class BruteForce {

	public static void main(String[] args) {
					// 0    1    2    3    4    5    6    7    8
		String S[] = {"A", "A", "A", "A", "B", "B", "C", "C", "B"};
		String P[] = {"A", "A", "B", "A", "A", "A", "C", "A", "B"};
		
		int j=0;
		for(int i=0; i<S.length; i++) {
			if(i==8) {
				System.out.println("���ڿ��� ��. Ž�� ����");
				break;
			}
			
			if(S[i].equals(P[j])) {
				System.out.println("S["+i+"]  = P["+j+"]. ��ĭ�̵�");
				j++;
				
			}else {
				System.out.println("S["+i+"] != P["+j+"]. ���� ��Ī ����!");
				System.out.println();
				i -= j;	//i : ���� ���������� �̵�	
				j = 0; //j : �������� �̵�
			}
		}
	}
}
