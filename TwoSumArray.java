// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

public int[] TwoSum(int[] a, int sum){
	// We can so this by brute force in O(n^2)
	// Better Implementation is using HashMap O(n)

	HashMap<Integer,Integer> h= new HashMap<Integer,Integer>();

	for(int i=0;i<a.length;i++){
		// HashMap contains (remaining sum value (key), index of the current value(value))
		// this method only works if the sum is made by unique integers
		// Also, one one solution

		if(h.contains(a[i])){
			return ({(int)h.get(a[i]),i})
		}
		else
			h.put((sum-a[0]),i);
	}


}