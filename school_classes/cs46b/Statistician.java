package bubble;

import java.util.*;


public class Statistician 
{
	private final static int N_REPETITIONS = 1000;
	
	
	//returns a array of random integers with values between -maxValue and maxValue
	private static int[] buildRandom(int length, int maxValue)
	{
		int[] array = new int[length];
		for (int i=0; i<length; i++)
			array[i] = (int)(Math.random()*(maxValue + 1));
		return array;
	}
	
	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length-2;i++) {
			if(a[i]>a[i+1]) {return false;}
		}
		return true;
	}
	
	private static void getStats(int arrayLength)
	{
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();
		
		for (int i=0; i<N_REPETITIONS; i++)
		{
			int[] array = buildRandom(arrayLength, arrayLength*100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			// Assert that the sorter sorted correctly.
			// Append # visits and # swaps to the array lists.

		}

		// Compute and print min/average/max number of visits.
		// Compute and print min/average/max number of swaps.

	}
	
	public static void main(String[] args)
	{
		int[] tiny = {1,24,5,25};
		int[] alreadySorted = {};//fill in your example
		int[] backward = {};//fill in your example
		System.out.println("Tiny");
		BubbleSorter tinySorted = new BubbleSorter(tiny);
		tinySorted.sort();
		System.out.println(tinySorted);
		
		System.out.println("Already Sorted");
		
		
		System.out.println("Backward");
	
        System.out.println("1000:");
        getStats(1000);
        
		System.out.println("3000:");
		getStats(3000);
		
	}
}
