package day0603;

public class Exponent {

	public static void main(String[] args) {
		
		System.out.println(Power(2, 9));
	}
	
	
	// �ð� ���⵵ : O(n)
	//  						��                     ����
	public static int Power(int base, int exponent) {
		
		int i=0;
		int result = 1; //C^0 = 1
		
		//�� n���� �� ����
		for(i=0; i < exponent; i++) {
			result *= base;
		}
		
		
		
		return result;
		
	}

}
