public class BinarySearch_R {

	public static void main(String[] args) {
		int arr[] = {1, 4, 7, 9, 11, 19, 23};
		int n = arr.length;
		int start = 0; 
		int end = n-1;
		 
		binary_R(arr, 11, start, end);
	}

	public static void binary_R(int arr[], int key, int start, int end) {
		
		int middle = (start+end)/2;
		
		if(arr[middle]==key) {
			System.out.println("�˻� ����"+(middle+1)+"��° �ε���!");
		
		}else if(arr[middle]<key) {
			binary_R(arr, key, middle+1, end);
		
		}else if(arr[middle] > key) {
			binary_R(arr, key, start, middle-1);
		
		}else {
			System.out.println("�˻� ����");
		}
	}
}
