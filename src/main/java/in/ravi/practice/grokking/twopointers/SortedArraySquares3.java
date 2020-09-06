/**
 * @author Ravi.Katiyar
 *

 * 
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 *
 * Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
 * 
 */
package in.ravi.practice.grokking.twopointers;

public class SortedArraySquares3 {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] makeSquares(int arr[]) {int[] squares = new int[arr.length];
    
	int left = 0;
	int right = arr.length -1;
	
	int outputIndex =  arr.length -1;
	while(left <= right) {
		
		int leftSquare = arr[left] * arr[left];
		int rightSquare = arr[right] * arr[right];
		
		if(leftSquare > rightSquare) {
			squares[outputIndex--] = leftSquare;
			left++;
		}else {
			squares[outputIndex--]=rightSquare;
			right --;
		}
		
	}
	
	
    return squares;
}
}


