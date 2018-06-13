package day0613;


public class InsertSort {

	static int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

	public static void main(String[] args) {
		
		insertionSort();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	 
	public static void insertionSort() {
		
		for(int i=1; i<arr.length; i++) {
			int standard = arr[i]; //������ ���� ������ ù���� ����(����)
			int sortedLast = i-1; //���ĵ� ���� ������ ������ �ε���
			
			                      //������ ���ĵ� ���� ������ �ε������� ������
			while(sortedLast >=0 && standard < arr[sortedLast]) {
				arr[sortedLast+1] = arr[sortedLast]; //�迭 ���������� �б�
				sortedLast--;
			}
			arr[sortedLast+1] = standard;
			
		}
	}

}
