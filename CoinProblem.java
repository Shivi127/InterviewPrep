
/**
 * @author shivangisingh
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and 
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/


public class CoinProblem {

	/**
	 * @param args
	 */
	static int count=0;
	
	public static int rcoin(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
//                	if coin value is greater than change 
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int total = 15;
	     int coins[] = {3,4,6,7,9};
	     System.out.println(rcoin(total, coins));
	}

}
