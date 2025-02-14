import java.util.*;

class InsertionSort{
	
	void insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
	
	public static void main(String []args){
		
		InsertionSort Is = new InsertionSort();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of Employees : ");
		int n = sc.nextInt();
		if(n==0){
			System.out.println("No Employees in array.");
		}
		else{
			int[] employeeID = new int[n];
			for(int i=0;i<n;i++){
				System.out.println("Enter the ID of Employees "+(i+1)+" : ");
				employeeID[i]=sc.nextInt();
			}
			Is.insertionSort(employeeID);
			
			System.out.print("Employee ID's in ascending order : ");
			
			for(int i=0;i<n;i++){
				System.out.print(employeeID[i]+" ");
			}
		}
	}
}