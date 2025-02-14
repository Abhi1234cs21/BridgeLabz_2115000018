import java.util.*;

class SelectionSort{
	
	void selectionSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int min_indx = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min_indx]){
					min_indx=j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[min_indx];
			arr[min_indx]=temp;
		}
	}
	
	public static void main(String []args){
		
		SelectionSort Ss = new SelectionSort();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of Students : ");
		int n = sc.nextInt();
		if(n==0){
			System.out.println("No Students in array.");
		}
		else{
			int[] studentScores = new int[n];
			for(int i=0;i<n;i++){
				System.out.println("Enter the Scores of Student "+(i+1)+" : ");
				studentScores[i]=sc.nextInt();
			}
			Ss.selectionSort(studentScores);
			
			System.out.print("Student Scores in ascending order : ");
			
			for(int i=0;i<n;i++){
				System.out.print(studentScores[i]+" ");
			}
		}
	}
}