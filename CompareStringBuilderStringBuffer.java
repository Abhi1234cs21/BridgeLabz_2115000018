import java.util.*;

class CompareStringBuilderStringBuffer{
	public static void main(String []args){
	
		int iteration = 1000000;
		String str = "hello";
		
		
		StringBuffer stringBuffer = new StringBuffer();
		long startTime = System.nanoTime();
		for(int i=0;i<iteration;i++){
			stringBuffer.append(str);
		}
		long endTime = System.nanoTime();
		long stringBufferTime = endTime-startTime;
		System.out.println("Total Time taken by StringBuffer is "+stringBufferTime+"ns.");
		
		StringBuilder stringBuilder = new StringBuilder();
		startTime = System.nanoTime();
		for(int i=0;i<iteration;i++){
			stringBuilder.append(str);
		}
		endTime = System.nanoTime();
		long stringBuilderTime = endTime-startTime;
		System.out.println("Total Time taken by StringBuilder is "+stringBuilderTime+"ns.");
		
		System.out.println("StringBuilder is "+(double) stringBufferTime / stringBuilderTime +" times faster than StringBuffer.");
		
	}
}