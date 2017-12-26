
public int kthsmallestElement(int[] a, int k){
        // Have to import PriorityQueue from import.java.utils.*;
        // Case 1: if k>a.length then return a trigger =-1
        
        if(a.length>k){
            return -1;
        }
        // Autoboxing will happen on it's own
        // PriorityQueue has internal Heap Implementation
        else{
            PriorityQueue<Integer> pq= new PriorityQueue<Integer>(); 
            
            for (int x:a){
                // add all elements to pq
                // This takes O(N) time
                pq.add(x);
            }
            int kthelement=0;
            // Popping out k values this takes O(KlgN) time
            for(int i=1;i<=k;i++){
                kthelement=pq.poll();
            }
            return kthelement;
        }
    }
