package day0603;

public class Exponent_dnq {

	public static void main(String[] args) {
		
		System.out.println(Power(2, 9));

	}
	//							  ��                     ����
	public static int Power(int base, int exponent) {
		
		if(exponent==1) { //C^1 = C
			return base;
		
		}else if(base==0) { //C^0 = 1
			return 1;
		}
		
		int Nbase;
		
		//������ �����κ��� �ٽ� ������ ������ ��� ȣ�� .. exponent=1 �� �ɶ����� 
		if(exponent % 2 == 0) { //������ ¦��
			Nbase = Power(base, exponent/2);
			return Nbase * Nbase; //�պ�
		
		}else { //������ Ȧ��
			Nbase = Power(base, (exponent-1)/2); //�����Ͽ� ���
			return (Nbase * Nbase) * base; //�պ�
		}
		
	}

}
