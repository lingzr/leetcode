public class MathProblem{
	//263. ugly number

	public boolean isUgly(int num) {
        if (num == 1){
        	return true;
        }else if(num <= 0){
        	return false;
        }
        while(num%2 == 0){
        	num = num/2;
        }
        while(num%3 == 0){
        	num = num/3;
        }
        while(num%5 == 0)
        	num = num/5;
        return (num == 1);
    } 
    //204. count primes
    //Count the number of prime numbers less than a non-negative number, n
    public int countPrimes(int n){
    	if(n <= 2){
    		return 0;
    	}
    	boolean[] nonprime = new boolean[n];
    	int count = 0;//count for nonprime
    	for (int i = 2;i < n ; i = i+1) {		
    		if (nonprime[i] == false) {
    			count = count+1;
    			for (int j = 2;i*j < n ;j = j+1 ) {
    				nonprime[i*j] = true;
    			}
    		}
    	}
    	
    	return count;
    }

    //264. ugly number ii
    public int nthUglyNumber(int n){
    	int[] ugly = new int[n];
    	ugly[0] = 1;
    	
    }

}