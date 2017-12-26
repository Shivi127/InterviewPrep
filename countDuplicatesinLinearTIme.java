public int countDuplicates(int[] a){
        // Have to import HashMap from import.java.utils.*;
        int duplicatescount=0;
        // Autoboxing will happen on it's own
        HashSet<Integer> hset= new HashSet<Integer>(); 
        
        for (int x:a){
            if(hset.add(x)){
                duplicatescount++;
            }
        }
        return duplicatescount;
    }
    }
