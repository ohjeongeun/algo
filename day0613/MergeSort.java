package day0613;


public class MergeSort {

	public static int[] temp = new int[8]; //���ĵǾ� �� �迭
	
	public static void main(String[] args) {
		int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
		
		mergeSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void mergeSort(int arr[], int start, int end) {
		int middle;
		//divide
		if(start < end) {
			
			middle = (start+end)/2;
			
			//list�� ���̰� 1�� �� ������ ��� ȣ��
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			
			//����
			merge(arr, start, middle, end);
		}
	}
	
	//merge
	public static void merge(int arr[], int start, int middle, int end) {
		
		int i=start;     // left ~ middle
		int j=middle+1; //middle+1 ~ right
		
		int k=start; //�� ���� ���ҵ� list�� �����Ͽ� �ӽ÷� ������ �迭�� index
		
		//�� ���� list�� ù ���ҵ� ��
		while(i<=middle && j<=end) {
			//������ ���� �߰�
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				k++; i++; 
			
			}else {
				
				temp[k] = arr[j];
				k++; j++;//���� ���� �ֱ� ���� ����
			}
		}
		
		//���� list�� ���Ұ� �������� ���
		while(i<=middle) {
			temp[k] = arr[i];
			k++; i++;
		}
		
		//������ list�� ���Ұ� �������� ���
		while(j<=end) {
			temp[k] = arr[j];
			k++; j++;
		}
		
		for(int index=start; index<=end; index++) {
			arr[index] = temp[index];
		}
		
	}

	
}
