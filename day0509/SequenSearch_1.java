public class SequenSearch_1 {

	public static void main(String[] args) {
		int arr[] = {5, 3, 7, 2, 19, 10, 1};
		int key= 8;
		
		sequentialSearch(arr, key);
	}
	
	public static void sequentialSearch(int arr[], int key) {
		
		int i=0;
		while(i<arr.length && arr[i]!=key) {
			i++;
		}
		if(i<arr.length) {
			System.out.println("find key!"+(i+1)+"��° ����");
		}else {
			System.out.println("�˻�Ƚ��="+(i+1)+". key�� �����ϴ�.");
		}
		
	}
}
