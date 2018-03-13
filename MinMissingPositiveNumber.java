public int smallestmissingpositive(int[] a){
    // This method should have O(n) runtime and O(1) space.

    // missing number can be between 1 and n
    for( int i =0;i<a.length;i++){
        while(a[i]!=i){
            // we are logically swapping
            // Case 1: number is smaller than 1 and bigger than array size then do nothing 
            if(a[i]<0 || a[i]>=a.length){
                break;
            }
            // Case 2: The number is already there- duplicates
            if(a[i]==a[a[i]]){
                break;
            }

            // else swap number into place

            int temp=a[i]
            a[i]=a[temp];
            a[temp]=temp;
        }
    }

    for(int i=0;i<a.length;i++){
        if(a[i]!=i+1){
            return i+1;
        }
    }
    }
