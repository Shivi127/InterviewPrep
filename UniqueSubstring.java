// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


static final int numberofcharacters= 256;

public int LongestUniqueSubstring(String s){
	// Similar to Kadane's Algorithm

	int max_len=1;
	int curr_len=1;
	int previous_index;
	// array storing the index where you last saw the character
	int[] visited = new int[numberofcharacters];

	// Step 1: Initialize all the indexes to -1 to indicate that the character has not been encountered
	for(int i=0;i<numberofcharacters;i++){
		visited[i]=-1;
	}

	// First charatcter 
	visited[s.charAt[0]];
	// Moving on to the other characters
	for(int i=1;i<numberofcharacters;i++){
		previous_index=visited[s.charAt[i]];

		// Case 1: if the current character is not already present in the substring or is not a part 
		// of the current substring

		if(previous_index == -1 || (i-curr_len)>previous_index){
			curr_len++;
		}

		else{
			// Also, when we are checking the NRCS, we should also check whether the end of the previous
			// NCRS was > max_length or not

			if(curr_len>max_len){
				max_len=curr_len;
			}

			curr_len= i-previous_index;
		} //closing the else

		// Also, update the index of the current character

		visited[s.charAt[i]]=i;
	}

	if(curr_len>max_len){
		max_len=curr_len;
	}

	return max_len;
}