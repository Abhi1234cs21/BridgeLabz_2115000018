import java.util.*;

class BubbleSort{
	
	void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String []args){
		
		BubbleSort bs = new BubbleSort();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of Students : ");
		int n = sc.nextInt();
		if(n==0){
			System.out.println("No Students in array.");
		}
		else{
			int[] studentMarks = new int[n];
			for(int i=0;i<n;i++){
				System.out.println("Enter the marks of Student "+(i+1)+" : ");
				studentMarks[i]=sc.nextInt();
			}
			bs.bubbleSort(studentMarks);
			
			System.out.print("Student marks in ascending order : ");
			
			for(int i=0;i<n;i++){
				System.out.print(studentMarks[i]+" ");
			}
		}
	}
}