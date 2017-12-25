 public void merge(int[] a, int[] temp,int left, int right){
        int leftEnd=(left+right)/2;
        int rightStart=leftEnd+1;
        int size=right-left+1;
        
        int tempLeft=left;
        int tempRight=rightStart;
        int index=left;
        
        
        while(tempLeft<leftEnd&& tempRight<right){
            if(a[tempLeft]<=a[tempright){
                temp[index++]=a[tempLeft++];
            }
            else{
                temp[index++]=a[tempRight++];
            }
        }
        
        // //once one list is emptied I just copy over the rest of the elements 
        // if(tempRight<right){
        //     while(tempRight<right){
        //      temp[index++]=a[tempRight++];
        //     }
        // }
        // if(tempLeft<left){
        //     while(tempLeft<left){
        //         temp[index++]=a[tempLeft++];
        //     }
        // }
        
        //even simpler way to do is use the built in method Uses StringBuilder :)
        System.arraycopy(a,tempLeft, temp, index,left-tempLeft+1);
        System.arraycopy(a,tempRight, temp, index,right-tempRight+1);
        System.arraycopy(temp,left,a,left,size)
    }
