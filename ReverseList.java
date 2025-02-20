import java.util.*;

class ReverseList{

	public static void reverseArrayList(List<Integer> arrayList){
		int left=0 , right = arrayList.size()-1;
		while(left<right){
			int temp = arrayList.get(left);
			arrayList.set(left,arrayList.get(right));
			arrayList.set(right,temp);
			left++;
			right--;
		}
	}
	
	public static void reverseLinkedList(List<Integer> linkedList){
		int size = linkedList.size();
		for(int i=0;i<size/2;i++){
			int temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(size - 1 - i));
            linkedList.set(size - 1 - i, temp);
		}
		
	}
	
	
	
	public static void main(String []args){
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		List<Integer> linkedList = new LinkedList<>(arrayList);
		
		System.out.println("Original List : ");
		System.out.println(arrayList);
		
		reverseArrayList(arrayList);
		reverseLinkedList(linkedList);
		
		System.out.println("Reversed ArrayList : ");
		System.out.println(arrayList);
		
		System.out.println("Reversed LinkedList : ");
		System.out.println(linkedList);
	}
}