//QuickSort choose a pivot and move elements smaller than the pivot to the left and larger to the right
    
    public void QuickSort(int[]a,left,right){
        if(left>=right){
            return;
        }
        else{
            //pick a pivot element.
            int p=a[(left+right/)2];
            //partition the array about the pivot - returns the dividing point
            int index= partition(a,left,right,p);
            quicksort(a,left,index-1);
            quicksort(a,index,right);
        }
    }
    
    public int partition(int[]a, int l, int r,int p){
        while(l<=r){
            while(a[l]<p){
                l++;
            }
            while(a[r]>p){
                r--;
            }
            
            if(l<=r){
                swap(a,l,r);
                l++;
                r--;
            }
        return l;
    }
